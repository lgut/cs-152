
/**
 * Write a description of class Recursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.math.*;
public class Recursion
{
    public int sumFirstNodd(int val)
    {
        if( val == 1){
            return val;
        }else{
            return sumFirstNodd(val-1) + 2*val -1;
        }
    }

    public int countDigits(long n)
    {
        if (n < 10){
            return 1;
        }else{
            return countDigits(n / 10) + 1;
        }
    }

    public int sumDigits(int n)
    {
        if (n < 10){
            return n;
        }else{
            return sumDigits(n/10) + n % 10;
        }
    }

    public void convertToBase2(int n){
        if(n == 0 || n == 1){
            System.out.print(n);
        }else{
            convertToBase2(n/2);
            System.out.print(n%2);
        }
    }

    public void convertToBase3(int n){
        if(n == 0 || n == 1 || n ==2){
            System.out.print(n);
        }else{
            convertToBase3(n/3);
            System.out.print(n%3);
        }
    }

    public void convertToBase(int n, int base){
        if (n < base){
            System.out.print(n);
        }else{
            convertToBase(n/base, base);
            System.out.print(n % base);
        }
    }
    // return sum of all elements in int array
    // list may be empty
    // param n is number of positions in array
    public int sumArray(int[] list, int n){
        if (n == 0){
            return 0;
        }else{
            return list[n-1] + sumArray(list, n - 1);
        }
    }
    public void printArrayList(ArrayList<?> list, int n){
        if(n>0){
            printArrayList(list, n-1);
            System.out.print(list.get(n-1) + "\t");
        }
    }
    public int countItem(int[] list, int len, int item){
        if (len==0){
            return 0;
        }else if(list[len-1] == item){
            return countItem(list, len-1, item) + 1;
        }else{
            return countItem(list, len-1, item);
        }
    }
    public int largest(int[] list, int len){
        if (len==1){
            return list[0];
        }else{
            int temp = largest(list, len -1);
            if (list[len-1] < temp){
                return temp;
            }else{
                return list[len - 1];
            }
        }
    }
    public boolean contains(int[] list, int len, int item){
        if(len == 1){
            return list[0] == item;
        }else if(len == 0){
            return false;
        }else if (list[len - 1] == item){
            return true;
        }else{
            return contains(list, len - 1, item);
        }
    }
    public int search(int[] list, int len, int query){
        if (len == 1){
            if (list[0] == query){
                return 0;
            }else{
                return -1;
            }
        }else if(list[len -1] == query){
            return len - 1;
        }else{
            return search(list, len - 1, query);
        }
    }
    public Flight searchF(Flight[] list, int n, String origin){
        if (n==0)
            return null; // this is retarded
        else if (list[n-1].getOrigin().equalsIgnoreCase(origin))
            return list[n-1];
        else
            return searchF(list, n - 1, origin);
    }
    public void printOnTime(Flight[] list, int len){
        if (len == 0){
            return;
        }else if (list[len -1].getStatus().equalsIgnoreCase("on time")){
            System.out.println(list[len - 1].toString());
            printOnTime(list, len - 1);
        }else{
            printOnTime(list, len - 1);
        }
    }
    public void printDelayedSFO(Flight[] list, int len){
        if (len > 0){
            printDelayedSFO(list, len -1);
            Flight flight = list[len - 1];
            if(flight.getStatus().equalsIgnoreCase("delayed") && flight.getDestination().equalsIgnoreCase("sfo") ){
                System.out.println(flight.toString());
            }
        }
    }
    public void assignPowersOfTwo(int[] list, int n){
        if (n==1){
            list[0] = 1;
        }else{
            assignPowersOfTwo(list, n - 1);
        }
    }
}
