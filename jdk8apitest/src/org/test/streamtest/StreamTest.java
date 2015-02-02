package org.test.streamtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    
    public static void main(String[] args) {
	
	List<String> datas = new ArrayList<String>();
	datas.add("bb");
	datas.add("cc");
	datas.add("aa");
	datas.add("dd");
	datas.add("aa");
	
	streamtest(datas);
    }
    
    private static void streamtest(List<String> datas)
    {
	
	Stream<String> stream = datas.stream();
	Optional<String> optional = stream.filter(str -> str.equals("aa")).findFirst();
	String string = optional.get();
	System.out.println(string);
    }

}