package jude.codingtest.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public static int carrier =0;
    public static List<ListNode> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ListNode nodea = new ListNode(5);
        /*
        ListNode nodeb = new ListNode(4);
        ListNode nodec = new ListNode(3);

        ListNode noded = new ListNode(5);
        ListNode nodee = new ListNode(6);
        ListNode nodef = new ListNode(4);

        nodea.next = nodeb;
        nodeb.next = nodec;
        noded.next = nodee;
        nodee.next = nodef;
        */
        addTwoNumbers(nodea, nodea);


//        String test = "babad";
//        String test = "cbbd";
//        String test = "abcdedcxccccccc";
//        String test ="lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
        String test ="aaabaaaa";
    }

    public static void addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        while(node1 != null || node2 != null) {
            addValue(node1, node2);
            node1 = node1.next;
            node2 = node2.next;
        }

        if(carrier == 1) {
            result.add(new ListNode(1));
        }

        for(ListNode node : result) {
            System.out.print("" + node.val + " ->");
        }
    }

    public static void addValue(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return;
        } if(l1 == null) {
            result.add(new ListNode(check(l2.val)));
        } else if(l2 == null) {
            result.add(new ListNode(check(l1.val)));
        } else {
            result.add(new ListNode(check(l1.val + l2.val)));
        }
    }

    public static int check(int value) {
        int result;
        if(value + carrier >= 10) {
            result = value + carrier - 10;
            carrier = 1;
        } else {
            result = value + carrier;
            carrier = 0;
        }

        return result;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        boolean flag = false;
        List<ListNode> list = new ArrayList<>();
        while(node1 != null) {
            int left = node1.val;
            int right;
            if(node2 == null) {
                right = 0;
            } else {
                right = node2.val;
            }
            int sum = left + right;
            if(sum >= 10) {
                sum = sum - 10;
                flag = true;
            } else {
                flag = false;
            }

            if(node1.next != null && flag)
                node1.next.val = node1.next.val +1;

            node1 = node1.next;
            if(node2 != null)
                node2 = node2.next;

            list.add(new ListNode(sum));
        }

        if(node2 == null) {
            if(flag) {
                ListNode temp = new ListNode(1);
                list.get(list.size()-1).next = temp;
            }
        } else {
            while(node2 != null) {
                int value = flag ? node2.val+1 : node2.val;
                list.add(new ListNode(value));
                node2 = node2.next;
            }
        }

        for(int i=0; i< list.size(); i++) {
            if(i+1 < list.size())
                list.get(i).next = list.get(i+1);
            System.out.print(list.get(i).val + " -> ");
        }
    }
}
