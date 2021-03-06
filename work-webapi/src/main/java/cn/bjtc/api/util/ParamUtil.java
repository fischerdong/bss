package cn.bjtc.api.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;

import cn.bjtc.api.ApiParam;

public class ParamUtil {
	
	public static List<Object> convertToViewList(ApiParam param,Class clazz){
		try {
			if(param.getData() == null || param.getData().size() <= 0){
				return null;
			}
			List<Object> list = new ArrayList<Object>(param.getData().size());
			for(Map<String,Object> map : param.getData()){
				Object view = clazz.newInstance();
				for(String key : map.keySet()){
					if(map.get(key)==null || map.get(key).toString().isEmpty()){continue;}
					Field field = clazz.getDeclaredField(key);
					field.setAccessible(true);
					Class<?> type = field.getType();
					if(type==Integer.class){
						field.set(view, Integer.valueOf(String.valueOf(map.get(key))));
					}else if(type==Double.class){
						field.set(view, Double.valueOf(String.valueOf(map.get(key))));
					}else if(type==Long.class){
						field.set(view, Long.valueOf(String.valueOf(map.get(key))));
					}else if(type==Boolean.class){
						field.set(view, Boolean.valueOf(String.valueOf(map.get(key))));
					}else{
						field.set(view, map.get(key));
					}
				}
				list.add(view);
			}
			return list;
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object convertToView(ApiParam param,Class clazz){
		try {
			Object view = clazz.newInstance();
			if(param.getData() != null && param.getData().size() > 0){
				Map<String,Object> map = param.getData().get(0);
				for(String key : map.keySet()){
					if(map.get(key)==null || map.get(key).toString().isEmpty()){continue;}
					Field field = clazz.getDeclaredField(key);
					field.setAccessible(true);
					Class<?> type = field.getType();
					if(type==Integer.class){
						field.set(view, Integer.valueOf(String.valueOf(map.get(key))));
					}else if(type==Double.class){
						field.set(view, Double.valueOf(String.valueOf(map.get(key))));
					}else if(type==Long.class){
						field.set(view, Long.valueOf(String.valueOf(map.get(key))));
					}else if(type==Boolean.class){
						field.set(view, Boolean.valueOf(String.valueOf(map.get(key))));
					}else{
						field.set(view, map.get(key));
					}
				}
			}
			Field pageIndex = clazz.getSuperclass().getDeclaredField("pageIndex");
			pageIndex.setAccessible(true);
			pageIndex.set(view, param.getPindex());
			Field pageSize = clazz.getSuperclass().getDeclaredField("pageSize");
			pageSize.setAccessible(true);
			pageSize.set(view, param.getPsize());
			return view;
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			return null;
		}
	}
}
