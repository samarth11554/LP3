import java.util.Arrays;
import java.util.Comparator;

class Item{
int value;
int weight;
public Item(int value , int weight){
this.value = value;
this.weight = weight;
}
double getRatio(){
return (double) value / weight;
}
}

public class FractionalKnapsack{
public static double knapsack(int capacity , Item[] items){
Arrays.sort(items , Comparator.comparingDouble(Item::getRatio).reversed());
double totalValue = 0.0;
int remainCapacity = capacity;
for(Item item : items){
if(item.weight <= remainCapacity){
remainCapacity -= item.weight;
totalValue += item.value;
}else{
double fraction = (double) remainCapacity / item.weight;
totalValue += item.value * fraction;
break;
}
}
return totalValue;
}

public static void main(String[] args){
Item[] items = {new Item(60, 10), new Item(100, 20),new Item(120, 30)};
double maxValue = knapsack(50 , items);
System.out.println("Max Value : " +maxValue);
}
}
