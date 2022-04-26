import time
from unittest import result
import pandas as pd
import pymysql

# 测试创建计算结果
#test = pd.DataFrame(data=None)
#i=time.time()
#test.to_excel("F:\Songhao\gs.数据集\计算结果+"+str(i)+".xls")

# 读取订单信息
db_shop_ssm = pymysql.connect(host='localhost',
                      user='root',
                      password='root',
                      database='2cshop_ssm')
# 写入权重信息
db_buying_preference = pymysql.connect(host='localhost',
                               user='root',
                               password='root',
                               database='buying_preference') 

cursor_shop_ssm = db_shop_ssm.cursor()
cursor_buying_preference = db_buying_preference.cursor()



# 更新用户偏好矩阵
sql_search_uid ="SELECT id FROM user"
sql_search_pid ="SELECT id FROM product"
# 提取用户id
try:
   # 执行SQL语句
   cursor_shop_ssm.execute(sql_search_uid)
   # 获取所有记录列表
   results_search_uid = cursor_shop_ssm.fetchall()
   # uid_all[]记录所有用户
   uid_all = []
   for row in results_search_uid:
       uid_all.append(row[0])   
except:
   print ("获取所有用户失败")
print("系统中存有用户："+str(uid_all))  
# 提取商品id
try:
   # 执行SQL语句
   cursor_shop_ssm.execute(sql_search_pid)
   # 获取所有记录列表
   results_search_pid = cursor_shop_ssm.fetchall()
   # uid_all[]记录所有用户
   pid_all = []
   for row in results_search_pid:
       pid_all.append(row[0])   
except:
   print ("获取所有商品失败")
print("系统中存有商品："+str(pid_all))  

# 查询原有用户
sql_search_now_uid = "SELECT id FROM user_preference"
try:
   # 执行SQL语句
   cursor_buying_preference.execute(sql_search_now_uid)
   # 获取所有记录列表
   results_search_now_uid = cursor_buying_preference.fetchall()
   # uid_all[]记录所有用户
   uid_now_all = []
   for row in results_search_now_uid:
       uid_now_all.append(row[0])
except:
   print ("获取当前所有用户失败")



for i in range (pid_all.__len__()):
    sql_insert_pid ="ALTER TABLE user_preference ADD `%s_weight` FLOAT" % (pid_all[i])
   # 执行SQL语句
    try:
        cursor_buying_preference.execute(sql_insert_pid)
        for j in range(uid_now_all.__len__()):
            sql_assign_product = "UPDATE user_preference SET %s_weight = 0 WHERE uid = %s" %(pid_all[i],uid_now_all[j])
            try:
                cursor_buying_preference.execute(sql_assign_product)
                db_buying_preference.commit()
            except:
                print("商品赋值失败")
    except:
        print(str(pid_all[i])+"已存在")
for i in range (uid_all.__len__()):
    sql_insert_uid ="INSERT INTO user_preference(uid) VALUES (%s)" %(uid_all[i])
    try:
        cursor_buying_preference.execute(sql_insert_uid)
        db_buying_preference.commit()
        for j in range(pid_all.__len__()):
            sql_assign_user = "UPDATE user_preference SET %s_weight = 0 WHERE uid = %s" %(pid_all[j],uid_all[i])
            try:
                cursor_buying_preference.execute(sql_assign_user)
                db_buying_preference.commit()
            except:
                print("用户赋值失败")
    except:
        print(str(uid_all[i])+"用户已存在")    

# sql_add = "INSERT INTO user_preference (`10`) VALUES (%s)" % (1) 
# try:    
#     cursor_buying_preference.execute(sql_add)
#     print(111111111)
#     db_buying_preference.commit()
# except:
#     print("添加失败")



# 清空喜好权重表
sql_delete = "DELETE FROM preference_weight"
try:
   # 执行SQL语句
    cursor_buying_preference.execute(sql_delete)
   # 提交到数据库执行
    db_buying_preference.commit()
except:
   # 发生错误时回滚
    print("清空喜好权重表失败")
    db_buying_preference.rollback()           

# 查询用户id
sql_select_uid = "SELECT uid FROM orderitem"
try:
   # 执行SQL语句
   cursor_shop_ssm.execute(sql_select_uid)
   # 获取所有记录列表
   results_uid = cursor_shop_ssm.fetchall()
   # uid[]记录存在购买记录的用户
   uid = []
   for row in results_uid:
       uid.append(row[0])   
except:
   print ("提取订单信息失败")
# 过滤购买信息
uid_filter = [uid[0]]
for i in range(uid.__len__()-1):
    if uid[i] != uid[i+1]:
        uid.append(uid[i+1])
print("存在购买记录的用户有"+str(uid_filter)) 

for i in range(uid_filter.__len__()):
    # 根据用户查询购买的商品
    sql_select_pid = "SELECT pid FROM orderitem \
                        WHERE uid = %s" %(uid_filter[i])
    try:
        # 执行SQL语句
        cursor_shop_ssm.execute(sql_select_pid)
        # 获取所有记录列表
        results_pid = cursor_shop_ssm.fetchall()
        # pid[]记录用户购买过的商品
        pid = []
        for row in results_pid:
            pid.append(row[0])   
    except:
        print ("提取商品信息失败")
    print(str(uid_filter[i])+"用户购买过的商品有"+str(pid))
    # 分析用户对于价格以及促销价格的偏好权重
    weight  = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    # 根据商品id（pid）查询商品价格区间以及促销区间    
    for j in range(pid.__len__()):
        # 根据pid查询商品价格及促销价格
        sql_get_originalPrice = "SELECT originalPrice FROM product \
                                WHERE id = %s" %(pid[j])
        sql_get_promotePrice = "SELECT promotePrice FROM product \
                                WHERE id = %s" %(pid[j])
        sql_get_cid = "SELECT cid FROM product \
                                WHERE id = %s" %(pid[j])
        try:
            # 执行SQL语句
            cursor_shop_ssm.execute(sql_get_originalPrice)
            # 获取所有记录列表
            results_get_originalPrice = cursor_shop_ssm.fetchall()
            originalPrice = []
            for row in results_get_originalPrice:
                originalPrice.append(row[0])
                if row[0]<100:
                    weight[0]=weight[0]+1
                elif row[0]<300:
                    weight[1] = weight[1]+1
                elif row[0]<600:
                    weight[2] = weight[2]+1
                elif row[0]<1000:
                    weight[3] = weight[3]+1
                elif row[0]>1000:
                    weight[4] = weight[4]+1       
        except:
            print ("提取商品初始价格失败")
        # print(originalPrice)
        try:
            # 执行SQL语句
            cursor_shop_ssm.execute(sql_get_promotePrice)
            # 获取所有记录列表
            results_get_promotePrice = cursor_shop_ssm.fetchall()
            # 记录促销百分比
            promotePrice_per = []
            for row in results_get_promotePrice:
                #row[0]=(originalPrice[0]-row[0])/originalPrice[0]
                #print((originalPrice[0]-row[0])/originalPrice[0])
                promotePrice_per.append((originalPrice[0]-row[0])/originalPrice[0])
                if promotePrice_per[0]<0.1:
                    weight[5]= weight[5]+1
                elif promotePrice_per[0]<0.3:
                    weight[6] = weight[6]+1
                elif promotePrice_per[0]<0.5:
                    weight[7] = weight[7]+1
                elif promotePrice_per[0]>0.5:
                    weight[8] = weight[8]+1
        except:
            print ("提取商品促销价格失败")        
        try:
            # 执行SQL语句
            cursor_shop_ssm.execute(sql_get_cid)
            # 获取所有记录列表
            results_get_cid = cursor_shop_ssm.fetchall()
            # 记录商品种类
            cid = []
            for row in results_get_cid:
                if row[0]==60:
                    weight[9]=weight[9]+1
                elif row[0]==64:
                    weight[10] = weight[10]+1
                elif row[0]==68:
                    weight[11] = weight[11]+1
                elif row[0]==69:
                    weight[12] = weight[12]+1
                elif row[0]==71:
                    weight[13] = weight[13]+1
                elif row[0]==72:
                    weight[14] = weight[14]+1
                elif row[0]==73:
                    weight[15] = weight[15]+1
                elif row[0]==74:
                    weight[16] = weight[16]+1
                elif row[0]==75:
                    weight[17] = weight[17]+1 
                elif row[0]==76:
                    weight[18] = weight[18]+1
                elif row[0]==77:
                    weight[19] = weight[19]+1
                elif row[0]==78:
                    weight[20] = weight[20]+1
                elif row[0]==79:
                    weight[21] = weight[21]+1
                elif row[0]==80:
                    weight[22] = weight[22]+1
                elif row[0]==81:
                    weight[23] = weight[23]+1
                elif row[0]==82:
                    weight[24] = weight[24]+1
                elif row[0]==83:
                    weight[25] = weight[25]+1    
                elif row[0]==84:
                    weight[26] = weight[26]+1                                     
        except:
            print ("提取商品属性失败") 




    # 得到用户购买记录中不同属性所占用百分比   
    sum_weight = 0     
    
    for j in range(weight.__len__()):    
        weight[j] = weight[j]/(pid.__len__())
        #weight[i] = weight[i]-2*(weight[i]-0.5)
        sum_weight = sum_weight+weight[j]
    print(weight)    
    
    for j in range(weight.__len__()):
        weight[j]=weight[j]/sum_weight
    print(weight)
    print(weight[22])
    #sql_write_weight = "REPLACE INTO preference_weight uid = '%s',price100_weight = '%s', \
    #                    price300_weight='%s',price600_weight='%s',price1000_weight='%s',price_more_weight='%s',\
    #                    promote0.1_weight='%s',promote0.3_weight='%s',promote0.5_weight='%s',promote_more_weight='%s'" \
    #                        %uid_filter[0]%weight[0]%weight[1]%weight[2]%weight[3]%weight[4]%weight[5]%weight[6]%weight[7]%weight[8]
    sql_write_weight = "INSERT INTO preference_weight (uid,price100_weight, \
                        price300_weight,price600_weight,price1000_weight,price_more_weight,\
                        promote10_weight,promote30_weight,promote50_weight,promote_more_weight,\
                        60_weight,64_weight,68_weight,69_weight,71_weight,72_weight,73_weight,\
                        74_weight,75_weight,76_weight,77_weight,78_weight,79_weight,80_weight,\
                        81_weight,82_weight,83_weight,84_weight) VALUES (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)" % \
                        (uid_filter[i],weight[0],weight[1],weight[2],weight[3],weight[4],weight[5],weight[6],weight[7],weight[8],weight[9],weight[10],weight[11],weight[12],weight[13],weight[14],weight[15],weight[16],weight[17],weight[18],weight[19],weight[20],weight[21],weight[22],weight[23],weight[24],weight[25],weight[26])
    # sql_write_weight ="INSERT INTO preference_weight (uid,price100_weight,price300_weight,price600_weight,price1000_weight,price_more_weight) VALUES (%s,%s,%s,%s,%s,%s) "  % (4,weight[0],weight[1],weight[2],weight[3],weight[4])                                        
    # sql_write_weight ="INSERT INTO preference_weight (60_weight) VALUES (%s)" % (6)
    
    try:
   # 执行SQL语句
        cursor_buying_preference.execute(sql_write_weight)
   # 提交到数据库执行
        db_buying_preference.commit()
    except:
   # 发生错误时回滚
        print("写入数据库失败")
        db_buying_preference.rollback()                    
    for j in range(pid_all.__len__()):
        sql_search_pid_all = "SELECT originalPrice,promotePrice,cid FROM product WHERE id = %s" %(pid_all[j])
        try:            
            # 执行SQL语句
            cursor_shop_ssm.execute(sql_search_pid_all)
            # 获取所有记录列表
            results_search_pid_all = cursor_shop_ssm.fetchall()
            weight_pid_all = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
            for row in results_search_pid_all:    
                if row[0]<100:
                    weight_pid_all[0] = weight_pid_all[0]+1
                elif row[0]<300:
                    weight_pid_all[1] = weight_pid_all[1]+1
                elif row[0]<600:
                    weight_pid_all[2] = weight_pid_all[2]+1
                elif row[0]<1000:
                    weight_pid_all[3] = weight_pid_all[3]+1
                elif row[0]>1000:
                    weight_pid_all[4] = weight_pid_all[4]+1
                promotePrice_per_pid_all = (row[0]-row[1])/row[0]
                if promotePrice_per_pid_all<0.1:
                    weight_pid_all[5] = weight_pid_all[5]+1
                elif promotePrice_per_pid_all<0.3:
                    weight_pid_all[6] = weight_pid_all[6]+1
                elif promotePrice_per_pid_all<0.5:
                    weight_pid_all[7] = weight_pid_all[7]+1
                elif promotePrice_per_pid_all>0.5:
                    weight_pid_all[8] = weight_pid_all[8]+1 
                    
                if row[2]==60:
                    weight_pid_all[9]=weight_pid_all[9]+1
                elif row[2]==64:
                    weight_pid_all[10] = weight_pid_all[10]+1
                elif row[2]==68:
                    weight_pid_all[11] = weight_pid_all[11]+1
                elif row[2]==69:
                    weight_pid_all[12] = weight_pid_all[12]+1
                elif row[2]==71:
                    weight_pid_all[13] = weight_pid_all[13]+1
                elif row[2]==72:
                    weight_pid_all[14] = weight_pid_all[14]+1
                elif row[2]==73:
                    weight_pid_all[15] = weight_pid_all[15]+1
                elif row[2]==74:
                    weight_pid_all[16] = weight_pid_all[16]+1
                elif row[2]==75:
                    weight_pid_all[17] = weight_pid_all[17]+1 
                elif row[2]==76:
                    weight_pid_all[18] = weight_pid_all[18]+1
                elif row[2]==77:
                    weight_pid_all[19] = weight_pid_all[19]+1
                elif row[2]==78:
                    weight_pid_all[20] = weight_pid_all[20]+1
                elif row[2]==79:
                    weight_pid_all[21] = weight_pid_all[21]+1
                elif row[2]==80:
                    weight_pid_all[22] = weight_pid_all[22]+1
                elif row[2]==81:
                    weight_pid_all[23] = weight_pid_all[23]+1
                elif row[2]==82:
                    weight_pid_all[24] = weight_pid_all[24]+1
                elif row[2]==83:
                    weight_pid_all[25] = weight_pid_all[25]+1    
                elif row[2]==84:
                    weight_pid_all[26] = weight_pid_all[26]+1               
        except:
            print ("权值计算有误")
        sum_score = 0    
        for t in range(weight_pid_all.__len__()):
            sum_score = sum_score + weight_pid_all[t]*weight[t]
        # 写库
        sql_write_user_preference = "UPDATE user_preference SET `%s_weight` = %s WHERE uid = %s" % (pid_all[j],sum_score,uid[i]) 
        try:
        # 执行SQL语句
             cursor_buying_preference.execute(sql_write_user_preference)
        # 提交到数据库执行
             db_buying_preference.commit()
        except:
        # 发生错误时回滚
             print("写入user_preference数据库失败")
             db_buying_preference.rollback()   
    
# 关闭数据库连接
db_shop_ssm.close()
db_buying_preference.close()







#sql_shop_ssm = "SELECT * FROM order_ \
#                WHERE uid = %s" % (5)
#try:
#   # 执行SQL语句
#   cursor_shop_ssm.execute(sql_shop_ssm)
#   # 获取所有记录列表
#   results = cursor_shop_ssm.fetchall()
#   print(results)
#   print(isinstance(results,tuple))
#   for row in results:
#       orderCode = row[1]
#       # 打印结果
#       print ("orderCode=%s" % \
#             (orderCode))
#except:
#   print ("Error: unable to fetch data")
# 
## 关闭数据库连接
#db_shop_ssm.close()
#
## 打开数据库连接
#db = pymysql.connect(host='localhost',
#                     user='root',
#                     password='root',
#                     database='buying_preference')
# 
## 使用cursor()方法获取操作游标 
#cursor = db.cursor()
#
##-# 查看数据库
##-cursor.execute("SELECT VERSION()")
##-# 使用 fetchone() 方法获取单条数据.
##-data = cursor.fetchone()
##- 
##-print ("Database version : %s " % data)
#
## SQL 更新语句
#sql = "UPDATE preference_weight SET price_weight = price_weight + 1 ,promote_weight = promote_weight + 1 WHERE uid = '%s'" % (1)
#try:
#   # 执行SQL语句
#   cursor.execute(sql)
#   # 提交到数据库执行
#   db.commit()
#except:
#   # 发生错误时回滚
#   db.rollback()
#  
## 关闭数据库连接
#db.close()