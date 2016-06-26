package com.nowcoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.ibatis.builder.StaticSqlSource;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.fabric.xmlrpc.base.Data;

public class Main {
	//打印对象
	public static void print(int index,Object obj){
		System.out.println(String.format("{%d}, %s",index,obj.toString()));
	}
	
	public static void demoOperation(){
		print(1, 5+2);
		print(2, 5-2);
		print(3, 5*2);
		print(4, 5/2);
		print(5, 5%2);
		print(6, 5<<2);
		print(7, 5>>2);
		print(8, 5|2);
		print(9, 5&2);
		print(10, 5^2);
		
		int a= 2;
		double b = 2.0;
		a +=2;
		print(11, a);
		print(12, b);	
	}
	
	public static void demoControlFlow(){
		int score = 65;
		if(score > 80){
			print(13, "A");
		}else if(score > 60){
			print(14, "B");
		}else{
			print(15,"C");
		}
		
		String grade = "B";
		switch(grade){
		case"A": print(16, "score > 80");break;
		case"B": print(17, "80 > score > 60");break;
		default:print(18, "60 > score > 0");break;
		}
		
		for(int i = 0; i < 6;i++){
			if(i==1){
				continue;
			}
			if(i==5){
				break;
			}
			if(i%2 == 1){
				print(19, "i%2=1");
			}
			print(20, i);
		}
		
		String str = "hello";
		for(char c: str.toCharArray()){
			print(21, c);
		}
		
		int target = 20;
		int current = 0;
		while(current < target){
			current+=5;
			print(22, current);
			if(current == 10){
				break;
			}
		}
	}
	
	public static void demoString(){
		String str = "hello nowcoder";
		print(1, str.indexOf('e'));//返回字符在字符串中的位置
		print(2, str.charAt(6));//返回字符串中指定位置的字符
		print(3, str.codePointAt(1));//返回字符串中指定字符的ASCII码
		print(4, str.compareTo("hello mowcoder"));//返回两个字符串中第一个不相同字符的ASCII差值
		print(5, str.compareTo("hello powcoder"));
		print(6, str.compareToIgnoreCase("Hello Nowcoder"));
		print(7, str.concat("!!"));//使字符串以指定字符串结尾
		print(8, str.contains("nox"));//判断字符串是否包含指定字符串
		print(9, str.endsWith("xowcoder"));//判断字符串是否以指定字符串结尾
		print(10, str.startsWith("hello"));//判断字符串是否以指定字符串开始
		print(11, str.lastIndexOf("o"));//返回指定字符在字符串中最后出现的位置
		print(12, str.toUpperCase());//将字符串小写字母转换成大写
		print(13, str.replace('o', 'a'));//将字符串中某个字符用指定字符替换
		print(14, str.replaceAll("o|l","a"));//可以用EL表达式，同时替换多个字符
		print(15, str.replaceAll("hello", "hi"));//将字符串中某段子串替换成指定字符串
		
		StringBuilder sb = new StringBuilder();
		sb.append(true);
		sb.append(1);
		print(16, sb.toString());
		print(17, "a"+"b"+String.valueOf(12));
	}
	public static void demoList(){
		List<String> strList = new ArrayList<String>();
		for(int i = 0;i < 4;i++){
			strList.add(String.valueOf(i));
		}
		print(1, strList);
	    List<String> strListB = new ArrayList<String>();
	    for (int i = 0; i < 4; ++i) {
	         strListB.add(String.valueOf(i * i));
	    }
		strList.addAll(strListB);
		print(2, strList);
		strList.remove(0);
		print(3, strList);
		strList.remove(String.valueOf(1));
		print(4,strList);
		print(5,strList.get(1));
		
		Collections.sort(strList);
		print(6, strList);
		Collections.sort(strList,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2){
				return o2.compareTo(o1);
			}
		});
		print(7, strList);
		
		Collections.reverse(strList);
		print(8, strList);
		
		int[] array = new int[]{1,2,3};
		print(9, array[1]);
	}	
	public static void demoSet(){
		Set<String> strSet = new HashSet<String>();
		for(int i = 0; i<3; i++){
			strSet.add(String.valueOf(i));
			strSet.add(String.valueOf(i));
			strSet.add(String.valueOf(i));
		}
		print(1, strSet);
		strSet.remove("1");
		print(2, strSet);
		print(3, strSet.contains(4));
		strSet.addAll(Arrays.asList(new String[]{"A","B","C"}));
		print(4, strSet);
		
		for(String value:strSet){
			print(5, value);
		}
		print(6, strSet.isEmpty());
		print(7, strSet.size());
	} 
	public static void demoKeyValue(){
		Map<String, String> map = new 	HashMap<String,String>();
		for(int i = 0;i < 4;i++){
			map.put(String.valueOf(i),String.valueOf(i*i));
		}
		print(1, map);
		for(Map.Entry<String, String> entry : map.entrySet()){
			print(2, entry.getKey() +":"+ entry.getValue());
		}
		print(3, map.keySet());
		print(4, map.values());
		print(5, map.containsKey(2));
		print(6, map.get("1"));
		//map.replace("1","A");
		print(7, map);
	}

	public static void demoException(){
		try {
			print(1, "hello");
			int a = 2;
			a = a/0;
			String b = null;
			b.indexOf('a');
			
		} catch (NullPointerException npe) {
			print(3, "空指针异常");
		}catch(Exception e){
			print(4, "Exception");
		}finally{
			print(2, "最后一定会会被执行");
			//一般用来做清理工作
		}
	}
	public static void demoCommon(){
		Random random = new Random();
		random.setSeed(1);//给定一个产生随机数的初值
		for(int i = 1;i < 4;i++){
			print(1, random.nextInt(100));
			print(2, random.nextDouble());
		}
		List<Integer> array = Arrays.asList(new Integer[]{1,2,3,4,5});
		print(3, array);
		Collections.shuffle(array);
		print(4, array);
		
		Date date = new Date();
		print(5, date);
		print(6, date.getTime());
		DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		print(7, dFormat.format(date));
		print(8, DateFormat.getDateInstance(DateFormat.FULL).format(date));
		
		print(9, UUID.randomUUID());
		print(10, Math.max(1, 2));
		print(11, Math.ceil(2.2));
		print(12, Math.floor(2.5));
		print(13,Math.log(2.77));
	}
	  public static Animal getAnimal(int type) {
	        //return new Animal("2", 1);
	        return new Human("Lei", 22, "CN");
	    }

	    public static void demoClass() {
	        Talking animal = new Animal("Jim", 1);
	        animal.say();
	        animal = new Human("Lei", 11, "CN");
	        animal.say();
	    }

	

	public static void main(String[] args) {
		System.out.println("hello nowcoder");
		print(0, "hello world!");
		//demoOperation();
		demoControlFlow();
		demoString();
		demoList();
		demoSet();
		demoKeyValue();
		demoException();
		demoCommon();
		demoClass();
	}

}
