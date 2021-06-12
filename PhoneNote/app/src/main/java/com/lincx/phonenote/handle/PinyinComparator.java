package com.lincx.phonenote.handle;

import java.util.Comparator;

import com.lincx.phonenote.domain.Contacts;

/**
 * 
 * @author lincx
 */
public class PinyinComparator implements Comparator<Contacts> {

	public int compare(Contacts o1, Contacts o2) {
		if(o1.getSortKey().equals("@") || o2.getSortKey().equals("#")) {
			return -1;
		} else if(o1.getSortKey().equals("#") || o2.getSortKey().equals("@")) {
			return 1;
		} else {
			return o1.getSortKey().compareTo(o2.getSortKey());
		}
	}

}
