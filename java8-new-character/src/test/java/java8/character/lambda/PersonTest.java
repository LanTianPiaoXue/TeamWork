package java8.character.lambda;

import java8.character.lambda.entity.Person;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by admin on 2017/7/8.
 */
public class PersonTest {
    @Test
    public void test1(){
        List<Person> persons = initPersons(10);
        long count = persons.stream().filter(person->person.getAge() > 15).peek(person1 -> System.out.println(person1.getName()+" "+person1.getAge())).count();
        System.out.println(count);

        printPersonsOlderThan(persons,15);
    }

    @Test
    public void test2(){
        List<Person> persons = initPersons(10);
        Predicate<Person> filter1 = person -> person.getAge()>=9;
        Predicate<Person> filter2 = person -> person.getAge()<12;
        long count =persons.stream().filter(person -> person.getAge()>=9).filter(person -> person.getAge()<12).peek(person -> System.out.println(person.getName()+" "+person.getAge())).count();
        long count2 =persons.stream().filter(filter1.and(filter2)).peek(person -> System.out.println(person.getName()+" "+person.getAge())).count();
        System.out.println(count+" "+count2);
        printPersonsWithinAgeRange(persons,9,12);
    }
    @Test
    public void test3(){
        List<Person> persons = initPersons(10);
//        persons.stream().filter(p-> p.getName().contains("Bob")).map(person -> person.getName()).collect(Collectors.toList()).forEach(System.out::println);
//        persons.stream().flatMap()

    }
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("70317", "曲阳");
        hashMap.put("71121", "在东");
        hashMap.put("70333", "商音");
        hashMap.put("80000", "有恒");
        for(Map.Entry<String, String> entry: hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key:" + key + ";value:" + value);
        }
    }
    @Test
    public void test4(){
        Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9)).flatMap(num->num.stream()).collect(Collectors.toList()).forEach(System.out::println);
        Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9)).map(num->num.stream()).collect(Collectors.toList()).forEach(System.out::println);
        Optional<Integer> min = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)).flatMap(num -> num.stream()).min((a, b) -> a.intValue() + b.intValue());
        System.out.println("min:"+min);
        Optional<Integer> min1 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)).flatMap(num -> num.stream()).min(Comparator.comparing(a->a.intValue()));
        System.out.println("min1:"+min1);
        Optional<Integer> max = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)).flatMap(num -> num.stream()).max((a, b) -> a.intValue() - b.intValue());
        System.out.println("max:"+max);
        System.out.println("min:"+min);
        Optional<Integer> max2 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)).flatMap(num -> num.stream()).max(Comparator.comparing(a->a.intValue()));
        System.out.println("max2:"+max2);
    }

    @Test
    public void test5(){
        String a = "qq";
        String b = "qq";
        String cc = new String("qq");
        Long ss = 12313123L;
        Object object = new Object();
        System.out.println(String.valueOf(ss));
         System.out.println(a==cc);
        System.out.println(a==b);
        Integer va = Stream.of(1,2,3,4,5,6,7).reduce(0,(d,f)->d.intValue()+f.intValue());
        System.out.println("va:"+va);
    }
    private List<Person> initPersons(int amount) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i <  amount; i++){
            Person person = new Person("Bob"+i,10+i);
            persons.add(person);
        }
        return persons;
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() > age) {
                System.out.println(p.getName()+" "+p.getAge());
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                System.out.println(p.getName()+" "+p.getAge());
            }
        }
    }

    /**
     * yyyy-MM-dd'T'HH:mm:ssXXX
     * YYYY-MM-DD HH:SS:MM
     */
    @Test
    public  void testRegex(){
//        String testStr = "2016-11-09T22:21:43+08:00";
        String testStr = "2016-11-09T22:21:43+08:00";
//        String regex = "([\\s\\S]*)(\\d{4})-([0-1]\\d)-([0-3]\\d)['T']([0-2]\\d):([0-5]\\d):([0-5]\\d)[+](\\d{2}):(\\d{2})([\\s\\S]*)";
        String regex = "(\\d{4})-([0-1]\\d)-([0-3]\\d)['T']([0-2]\\d):([0-5]\\d):([0-5]\\d)[+](\\d{2}):(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(testStr);
        boolean flag = matcher.matches();
        System.out.println(flag);

    }
}
