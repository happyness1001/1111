package com.ppq.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AssociationRuleUtils {
	private static Map<Double, Double> timeStatistics = new HashMap<>();
	private static Map<Double, List<Pattern>> patternsForSupport = new HashMap<>();
	private static Map<List<String>,Integer> patternsMap = new HashMap<>();
	static double minConfidence;//最小置信度
	static double minSupport;//最小支持度
	static List<List<String>> database;//数据集
	public Map<List<String>,Double> getAssociationRules(List<List<String>> database,double minSupport,double minConfidence){
		this.minConfidence = minConfidence;
		this.minSupport = minSupport;
		this.database = database;
		getFrequentPatterns(minSupport, database);
		List<Pattern> patterns = patternsForSupport.get(minSupport);
		setPatternsMap(patterns);
		Map<List<String>, Double> rules = associationRulesMining(patterns);
		return rules;
	}

	public static void setPatternsMap(List<Pattern> frequentItemset){
		for (Pattern pattern : frequentItemset) {
			patternsMap.put(pattern.itemsList,pattern.supportValue);
		}
	}
	public static Map<List<String>,Double> associationRulesMining(List<Pattern> frequentItemSet)//关联规则挖掘
	{
		Map<List<String>,Double> associationRules = new HashMap<>();
		for(int i=0;i<frequentItemSet.size();i++)
		{
			List<String> tem=frequentItemSet.get(i).itemsList;
			if(tem.size()>1) {
				List<String> temclone=new ArrayList<>(tem);
				List<List<String>> AllSubset = getSubSet(temclone);//得到频繁项集tem的所有子集
				for (int j = 0; j < AllSubset.size(); j++) {
					List<String> s1 = AllSubset.get(j);
					List<String> s2 = gets2set(tem, s1);
					double conf = isAssociationRules(s1, s2, tem);
					if (conf > 0 && s1.size() == 1 && s2.size() == 1){
						List<String> list = new ArrayList<>();
						list.add(s1.get(0));
						list.add(s2.get(0));
						associationRules.put(list,conf);
					}
				}
			}
		}
		return associationRules;
	}
	public static List<List<String>> getSubSet(List<String> set){
		List<List<String>> result = new ArrayList<>();	//用来存放子集的集合，如{{},{1},{2},{1,2}}
		int length = set.size();
		int num = length==0 ? 0 : 1<<(length);	//2的n次方，若集合set为空，num为0；若集合set有4个元素，那么num为16.
		//从0到2^n-1（[00...00]到[11...11]）
		for(int i = 1; i < num-1; i++){
			List<String> subSet = new ArrayList<>();
			int index = i;
			for(int j = 0; j < length; j++){
				if((index & 1) == 1){		//每次判断index最低位是否为1，为1则把集合set的第j个元素放到子集中
					subSet.add(set.get(j));
				}
				index >>= 1;		//右移一位
			}
			result.add(subSet);		//把子集存储起来
		}
		return result;
	}
	public static  List<String> gets2set(List<String> tem, List<String> s1)//计算tem减去s1后的集合即为s2
	{
		List<String> result=new ArrayList<>();

		for(int i=0;i<tem.size();i++)//去掉s1中的所有元素
		{
			String t=tem.get(i);
			if(!s1.contains(t))
				result.add(t);
		}
		return  result;
	}
	public static double isAssociationRules(List<String> s1,List<String> s2,List<String> tem)//判断是否为关联规则
	{
		double confidence=0;
		int counts1;
		int countTem;
		if(s1.size()!=0&&s1!=null&&tem.size()!=0&&tem!=null)
		{
			counts1 = patternsMap.get(s1);
			countTem = patternsMap.get(tem);
			confidence=countTem*1.0/counts1;
			if(confidence>=minConfidence)
			{
				return confidence;
			}
			else
				return 0;
		}
		else
			return 0;
	}
	private static void getFrequentPatterns(double minSupportPercent, List<List<String>> database) {
		long elapsedTime = 0;

		long startTime = System.nanoTime();

		int minSupportCount = (int) (minSupportPercent * database.size());

		List<Pattern> patterns = new Apriori(database, minSupportCount).getAllFrequentItemsets();
		elapsedTime += System.nanoTime() - startTime;

		timeStatistics.put(minSupportPercent, elapsedTime / 1E9);
		patternsForSupport.put(minSupportPercent, patterns);
	}

}
