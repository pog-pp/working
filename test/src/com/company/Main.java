package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*Банкомат принимает и выдает купюры номиналом 1, 3, 5, 10, 25, 50, 100, 500, 1000 и 5000 рублей.
 Изначально банкомат пуст и из него нельзя ничего получить.
Введенная команда повторяется на экран до вывода сообщений от банкомата с префиксом>.
Банкомат управляется следующими командами:
+1) put <D> <count> – по успеху выводится сообщение, сколько всего денег в банкомате

Пример: put 5 17 - положить в банкомат 17 купюр по 5 рублей
Вывод: всего <количество денег в банкомате>

2) get <amount> – выводит в одну строку через запятую выдаваемую сумму в формате <D>=<count>
Пример: get 135 – получить из банкомата сумму в 135 рублей
Вывод: 50=2,10=2,5=3, всего 135
ИСКЛЮЧЕНИЕ:
В случае, когда банкомат не может точно выдать требуемую сумму,
он выводит сколько смог выдать и невыданный остаток в виде «без ННН» на следующей строке:
исходное состояние
put 10 4

вывод: 40

get 50

вывод: 10=4, всего 40

без 10

+dump – выводит количество денег в банкомате в формате <D> <count>
по строке на номинал купюры в порядке убывания номинала

+state – выводит количество денег в автомате

+quit – завершает работу с банкоматом

Напишите программу на java, которая читает команды пользователя из стандартного входа (stdin),
 обрабатывает их и пишет ответ в стандартный выход (stdout).*/

public class Main  {

    static Map<Integer, Integer> map = new HashMap<>();
    final static ArrayList<Integer> values = new ArrayList<Integer>(){{
        add(5000); add(1000); add(500); add(100); add(50); add(25); add(10); add(5); add(3); add(1);
    }};

public static void main(String [] args) throws IOException {

    String[] command = null;
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    do{
        String str = bf.readLine();
        command = str.split(" ");
        switch (command[0]){
            case ("put") : put(str);
                break;
            case ("state") : System.out.println("Денег всего " + state());
                break;
            case ("dump") : dump();
                break;
            case ("get") : get(str);
                break;
        }

    }while (!command[0].equals("quit"));
    bf.close();
}
    public static void put(String str){
        String[] command = str.split(" ");
        int c = 0, d = 0;
        if (command.length==3) {
            try{
             d = Integer.parseInt(command[1]);
             c = Integer.parseInt(command[2]);
            }catch(NumberFormatException ex){

            }
            if (values.contains(d) && c > 0) {
                if (map.containsKey(d)) {
                    map.put(d, c + map.get(d));
                } else {
                    map.put(d, c);
                }
                System.out.println(">" + "put " + d + " " + c);
                System.out.println("всего " + d * c);
            }
        }
    }

    public static void get(String str){
        String[] command = str.split(" ");
        int need = 0;
        if (command.length == 2){
            try{
         need = Integer.parseInt(command[1]);
            }catch(NumberFormatException ex){
                System.out.println("Введите другую сумму");
            }
        if (need > 0){
                int digit,c;
                int part = need;
                Map<Integer,Integer> subSum = new HashMap<>();
                for(int k : values){
                    if(map.containsKey(k) && map.get(k)>0){
                        digit = map.get(k);
                        c = part / k;
                        if (c != 0) {
                            if (c <= digit){
                                subSum.put(k,c);
                                map.put(k, digit-c);
                                part -=  c*k;
                            }else{
                                subSum.put(k,digit);
                                map.put(k,0);
                                part -= digit*k;
                            }
                        }
                    }
                }
                for (int i : values){
                    if (subSum.containsKey(i)) {
                        System.out.print(i + "=" + subSum.get(i)+",");
                    }
                }
                System.out.println(" всего  " + (need- part));
                if (part != 0){
                    System.out.println("Должны " + part);
                }
        }
    }
    }


    public static void dump(){
        for (int i : values) {
            if (map.containsKey(i)) {
                int val = map.get(i);
                if (val != 0) {
                    System.out.println(i + " = " + val);
                }
            }
        }
    }


    public static int state(){
        int sum = 0;
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer,Integer>  entry : set) {
            sum +=  entry.getKey() * entry.getValue();
        }
        return sum;
    }


}
