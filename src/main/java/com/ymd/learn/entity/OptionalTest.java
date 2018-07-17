package com.ymd.learn.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.collect.Maps;

public class OptionalTest {
	
	public static void main(String[] args) {
//		Optional<Integer> val = Optional.ofNullable(null);
//		System.out.println(val.get());
	
//		User user = null;
//		
//		Preconditions.checkNotNull(user);
		
		List<String> valList = Arrays.asList("michael", "sara", "alex", "mile",null);
		String val = valList.stream().collect(Collectors.joining(";"));
		System.out.println("val="+val);
		
		String val2 = Joiner.on(";").skipNulls().join(valList);
		System.out.println("val2="+val2);
		String val3 = Joiner.on(";").useForNull("HAHA").join(valList);
		System.out.println("val3="+val3);
		
		Map<String, String> nameMap = Maps.newHashMap();
		nameMap.put("Michael", "33");
		nameMap.put("Alex", "19");
		
		
		System.out.println(Joiner.on(";").withKeyValueSeparator("=").join(nameMap));	
		
		
		StringBuilder sb = new StringBuilder();
		Joiner joiner = Joiner.on("|").skipNulls();
		
		joiner.appendTo(sb, "A", "B", "C", null);
		
		System.out.println(sb.toString());
		
		
		
		
		
		
	}
}
