package java8.character.lambda;

import java8.character.lambda.dao.DbData;
import java8.character.lambda.entity.Album;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/7/8.
 */
public class LambdaDemotest {
   @Test
    public void test1(){
//       MyAction myAction =  new MyAction();
//       new LambdaDemo().excuteresult(myAction);
//       String s = "aaa";
       new LambdaDemo().excuteresult((String param) -> {
           System.out.println(param);
       });
       new LambdaDemo().excuteresult(System.out::println);
       new LambdaDemo().excuteresult(System.out::println);
//       new Thread(()-> {
//           int i =0;
//           i++;
//           System.out.println(i);
//       }).start();

       new LambdaDemo().say((String param,Integer count)->{
           System.out.println("adadasd");
           System.out.println("adadasd");
           System.out.println("adadasd");
           System.out.println("adadasd");
           System.out.println("adadasd");
       });
    }

    @Test
    public void test2(){
        //old way for looper
        List<String> features = Arrays.asList(new String[]{"a","b","c","d","e","f"});
//        for (String str:features) {
//            System.out.println("str:"+str);
//        }

        //lambda for looper
//        features.forEach((str)->{
//            System.out.println("n:"+str);
//        });
//        features.forEach(System.out::println);
        features.stream().map(name->name.toLowerCase()).peek(System.out::println).collect(Collectors.toList());
    }



    public static void main(String args[] ){
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);

        filter(languages, (str)->new LambdaDemotest().resultFlag("a"));
    }
    public static void filter(List<String> names, Predicate<String> condition) {
        for(String name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }


    private boolean resultFlag(String string){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return StringUtils.equals("a",string);
    }

    private boolean isNullObj(){
        return true;
    }
    @Test
    public  void test3(){
        List<String> list = Arrays.asList("a","b","c","a12sd","dweqwe");
       final List<String> listNew = new ArrayList<String>();
        List<String> listNew1 = new ArrayList<String>();
      /*  for(String str:list){
            String upCaseStr = str.toUpperCase();
            System.out.println("upCaseStr:"+upCaseStr);
            listNew.add(str);
        }*/

//        list.forEach(str->{
//            str =  str.toUpperCase();
//            System.out.println("str:"+str);
//            listNew.add(str);
//        });
//        list.forEach(String::toUpperCase);
        listNew1 =  list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("listNew1:"+listNew1);

        Long count = list.stream().filter(str->{
            return str.contains("a");
        }).count();
        System.out.println("times:"+count);

//        Stream.of()
    }
    @Test
    public void test5(){
        List<Integer> integerList1 = new ArrayList<Integer>();
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(5,6,7,8);
        List<Integer> list = Stream.of(list1,list2,Arrays.asList(1,2,3,4)).flatMap(nums->nums.stream()).collect(Collectors.toList());
        list.forEach(str-> System.out.println("str:"+str));

       Integer minValue = list.stream().min(Comparator.comparing(num->num)).get();
        System.out.println("minValue:"+minValue);

        Integer sum = Stream.of(1,2,3).reduce((s,e)->s+e).get();
        System.out.println("sum:"+sum);
    }

    @Test
    public void test6(){
        Predicate<Integer> predicateInteger = a->a>5;
        System.out.println(predicateInteger.test(2));
        System.out.println(predicateInteger.and( t->t>5));
        System.out.println(predicateInteger.negate());
        System.out.println(predicateInteger.or(predicateInteger));
        System.out.println(predicateInteger.toString());
    }


    @Test
    public void test7(){
        List<Album> albumList = new DbData().getAlbums(3,5,4);
        albumList.stream().flatMap(album -> album.getMusicians().stream()).map(artist -> artist.getName().contains("aa"));
        albumList.stream().flatMap(album -> album.getMusicians().stream()).peek(artist -> artist.getName());
    }
}
