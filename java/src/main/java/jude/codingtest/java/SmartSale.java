package jude.codingtest.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A sales executive needs to simplify an assigned sales task. The task is to sell the items given to her in a bag, where each item has an ID number.
 * It is easier to sell items with the same ID numbers. The sales executive also decides to remove some items from the bag. The largest number of items that she can remove is also known to her. Find the minimum number of different IDs the final bag can contain after removing the allowed number of items.
 * For example, she starts with a bag that contains the following n = 6 items: ids = [1,1,1,2,2,3] and she can remove m = 2 items. If she removes 2 of item 1, she will still have items of all three types. She could remove 2 of item 2, and have ids = [1,1,1,3] with 2 discrete item types or remove 1 each of types 2 and 3 leaving ids = [1,1,1,2]. Either way, there are 2 item types left.
 * Function Description
 * Complete the function deleteProducts in the editor below. The function must return an integer that denotes the minimum number of different IDs the final bag can contain.
 */
public class SmartSale {

    static int ids[] = {1,2,3,4,5,6,7,8,9,10};
    //an array of n integers that denotes the ID numbers of all items
    static int bag[] = {1,3,3,3,3};
    static int m = 3; //integer that denotes the maximum number of items that can be deleted from the bag.

    public static void main (String[] args) throws java.lang.Exception
    {

        if(m >= bag.length) {
            System.out.println(0);
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        List<SaleItem> items = new ArrayList<>(bag.length);
        for(int item : bag) {
            Integer NumOfItem = map.get(item);
            map.put(item, NumOfItem == null ? 1 : NumOfItem+1);
        }

        int kindOfItems = map.size();
        List<Integer> keyList = new ArrayList<>(kindOfItems);
        keyList.addAll(map.keySet());
        for(int i=0; i< keyList.size(); i++) {
            int key = keyList.get(i);
            int value = map.get(key);
            items.add(new SaleItem(key, value));
        }

        Collections.sort(items);
        List<SaleItem> result = new ArrayList<>(items);
        for(int i = 0; i < items.size(); i++) {
            SaleItem item = items.get(i);
            int sum  = m - item.count;
            if(sum >= 0) {
                result.remove(i);
                m = sum;
            } else {
                break;
            }
        }

        System.out.println(result.size());
    }
}
