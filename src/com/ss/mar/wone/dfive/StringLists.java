package com.ss.mar.wone.dfive;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Encloses specificCondition
 * @author Mosaab
 */
public class StringLists {
    /**
     * Filters elements from a list only if they start with the letter a and are 3 letters long
     * @return string list
     */
    public List<String> specificCondition(List<String> arrayList) {
        return arrayList.stream().filter(p -> ('a' == p.charAt(0) && p.length() == 3)).collect(Collectors.toList());
    }
}
