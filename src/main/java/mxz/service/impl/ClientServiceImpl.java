package mxz.service.impl;

import mxz.commons.constants.Constants;
import mxz.dao.ClientDao;
import mxz.entity.Client;
import mxz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    //注册新用户
    public Integer register(Client client) {
        if (clientDao.findByName(client.getName()) != null) {
            //用户名已存在
            return -1;
        }
        //取毫秒前10位即精确到秒，纳秒后9位取余1000精确到微秒。生成16位时间戳
        Long microsecond = System.nanoTime() / 1000 % 1000000;
        String timeStamp = System.currentTimeMillis() / 1000L + (microsecond < 100000 ? "0" : "") + microsecond;
        String uid = client.getUserType() + "邮政编码" + timeStamp;
        client.setUid(uid);

        //添加创建时间
        client.setCreateDateTime(new Timestamp(System.currentTimeMillis()));
        return clientDao.add(client);
    }

    @Override
    public Client login(Client client) {
        //查询对应账户名的用户
        Client findClient = clientDao.findByName(client.getName());
        System.out.println("service中" + findClient);
        //账户不存在或密码不正确时，返回null
        if (findClient == null) {
            return null;
        } else if (client.getPassword().equals(findClient.getPassword())) {
            findClient.setUserType(Constants.USER_TYPE_CLIENT);
            return findClient;
        } else {
            return null;
        }
    }

    //修改用户信息
    public Integer update(Client client) {
        return clientDao.update(client);
    }

    //通过uid查找用户
    public Client findByUid(String uid) {
        return clientDao.findByUid(uid);
    }

    //删除用户
    public Integer delete(String uid) {
        return clientDao.delete(uid);
    }

    @Override
    public Client findByPhone(String phone) {
        return null;
    }

    public Client findByName(String name) {
        return clientDao.findByName(name);
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
