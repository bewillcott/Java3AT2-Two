/*
 *  File Name:    AvlTreeTest.java
 *  Project Name: Common
 *
 *  Copyright (c) 2021 Bradley Willcott
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * ****************************************************************
 * Name: Bradley Willcott
 * ID:   M198449
 * Date: 28 Aug 2021
 * ****************************************************************
 */
package com.bewsoftware.tafe.java3.at2.two.common;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author <a href="mailto:bw.opensource@yahoo.com">Bradley Willcott</a>
 */
public class AvlTreeTest
{

    private static final int[] UNSORTED_LIST =
    {
        4, 1, 7, 3, 10, 2, 9, 6, 5, 8, 11
    };
    private static final int[] SORTED_LIST =
    {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
    };

    private static final String SORTED_STRING = "1,2,3,4,5,6,7,8,9,10,11,";

    public AvlTreeTest()
    {
    }

    @BeforeAll
    public static void setUpClass()
    {
    }

    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Test of add method, of class AvlTree.
     */
    @Test
    public void testAdd_GenericType()
    {
        AvlTree<Integer> list = generateList();

        for (int i = 0; i < SORTED_LIST.length; i++)
        {
            Assertions.assertEquals(SORTED_LIST[i], (int) list.get(i));
        }
    }

    /**
     * Test of add method, of class AvlTree.
     */
//    @Test
    public void testAdd_int_GenericType()
    {
        // not impl
    }

    /**
     * Test of addAll method, of class AvlTree.
     */
    @Test
    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    public void testAddAll_Collection()
    {
        List<Integer> unsorted = new ArrayList<>();

        for (int i : UNSORTED_LIST)
        {
            unsorted.add(i);
        }

        AvlTree<Integer> list = new AvlTree<>(unsorted);

        for (int i = 0; i < SORTED_LIST.length; i++)
        {
            Assertions.assertEquals(SORTED_LIST[i], list.get(i));
        }

    }

    /**
     * Test of addAll method, of class AvlTree.
     */
//    @Test
    public void testAddAll_int_Collection()
    {
        // not impl
    }

    /**
     * Test of clear method, of class AvlTree.
     */
    @Test
    public void testClear()
    {
        AvlTree<Integer> list = new AvlTree<>();

        list.add(123);
        list.add(56);

        Assertions.assertEquals(2, list.size());
        Assertions.assertNotEquals(20, list.size());
        list.clear();
        Assertions.assertEquals(0, list.size());
    }

    /**
     * Test of contains method, of class AvlTree.
     */
    @Test
    public void testContains()
    {
        AvlTree<Integer> list = generateList();

        Assertions.assertTrue(list.contains(2));
        Assertions.assertFalse(list.contains(20));
        Assertions.assertThrows(NullPointerException.class, () ->
                        {
                            list.contains(null);
                        });
    }

    /**
     * Test of containsAll method, of class AvlTree.
     */
//    @Test
    public void testContainsAll()
    {
        // not impl
    }

    /**
     * Test of delete method, of class AvlTree.
     */
    @Test
    public void testDelete()
    {
        AvlTree<Integer> list = generateList();

        Assertions.assertFalse(list.delete(50));
        Assertions.assertTrue(list.contains(5));

        Assertions.assertTrue(list.delete(5));
        Assertions.assertFalse(list.contains(5));
    }

    /**
     * Generate test list AvlTree.
     *
     * @return new AvlTree object
     */
    private AvlTree<Integer> generateList()
    {
        AvlTree<Integer> list = new AvlTree<>();

        for (int i : UNSORTED_LIST)
        {
            list.add(i);
        }

        return list;
    }

//    /**
//     * Test of get method, of class AvlTree.
//     */
//    @Test
//    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
//    public void testGet()
//    {
//        AvlTree<Integer> list = generateList();
//        Assertions.assertEquals(5, list.get(4));
//        Assertions.assertNotEquals(5, list.get(5));
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
//                        {
//                            list.get(list.size());
//                        });
//    }
    /**
     * Test of getCount method, of class AvlTree.
     */
    @Test
    public void testGetCount()
    {
        AvlTree<Integer> list = generateList();
        Assertions.assertEquals(11, list.size());
        Assertions.assertNotEquals(5, list.size());
    }

//    /**
//     * Test of indexOf method, of class AvlTree.
//     */
//    @Test
//    public void testIndexOf()
//    {
//        AvlTree<Integer> list = generateList();
//        Assertions.assertEquals(10, list.indexOf(11));
//        Assertions.assertNotEquals(5, list.indexOf(1));
//        Assertions.assertThrows(NullPointerException.class, () ->
//                        {
//                            list.indexOf(null);
//                        });
//    }
    /**
     * Test of isBalanced method, of class AvlTree.
     */
    @Test
    public void testIsBalanced()
    {
        AvlTree<Integer> list = new AvlTree<>();
        Assertions.assertTrue(list.isBalanced());

        list = new AvlTree<>(false);
        Assertions.assertFalse(list.isBalanced());

        List<Integer> src = new ArrayList<>();
        src.add(12);
        list = new AvlTree<>(src);
        Assertions.assertTrue(list.isBalanced());
        list = new AvlTree<>(src, false);
        Assertions.assertFalse(list.isBalanced());
    }

    /**
     * Test of isEmpty method, of class AvlTree.
     */
    @Test
    public void testIsEmpty()
    {
        AvlTree<Integer> list = new AvlTree<>();
        Assertions.assertTrue(list.isEmpty());

        list.add(23);
        Assertions.assertFalse(list.isEmpty());
    }

    /**
     * Test of iterator method, of class AvlTree.
     */
    @Test
    public void testIterator()
    {
        AvlTree<Integer> list = generateList();
        StringBuilder sb = new StringBuilder();

        list.forEach(next ->
        {
            sb.append(next.toString()).append(',');
        });

        Assertions.assertEquals(SORTED_STRING, sb.toString());
    }

    /**
     * Test of lastIndexOf method, of class AvlTree.
     */
//    @Test
    public void testLastIndexOf()
    {
        // not impl
    }

    /**
     * Test of listIterator method, of class AvlTree.
     */
//    @Test
    public void testListIterator_0args()
    {
        // not impl
    }

    /**
     * Test of listIterator method, of class AvlTree.
     */
//    @Test
    public void testListIterator_int()
    {
        // not impl
    }

    /**
     * Test of remove method, of class AvlTree.
     */
    @Test
    public void testRemove_Object()
    {
        AvlTree<Integer> list = generateList();
        Assertions.assertTrue(list.remove(7));
        Assertions.assertFalse(list.contains(7));

        Assertions.assertFalse(list.remove(7));
    }

    /**
     * Test of remove method, of class AvlTree.
     */
//    @Test
    public void testRemove_int()
    {
        // not impl
    }

    /**
     * Test of removeAll method, of class AvlTree.
     */
    @Test
    public void testRemoveAll()
    {
        List<Integer> killList = new ArrayList<>();

        for (int i = 0; i < UNSORTED_LIST.length; i++)
        {
            killList.add(UNSORTED_LIST[i]);
        }

        AvlTree<Integer> list = generateList();
        Assertions.assertTrue(list.removeAll(killList));
    }

    /**
     * Test of retainAll method, of class AvlTree.
     */
//    @Test
    public void testRetainAll()
    {
        // not impl
    }

    /**
     * Test of set method, of class AvlTree.
     */
//    @Test
    public void testSet()
    {
        // not impl
    }

    /**
     * Test of size method, of class AvlTree.
     */
    @Test
    public void testSize()
    {
        AvlTree<Integer> list = generateList();
        Assertions.assertEquals(11, list.size());
    }

    /**
     * Test of subList method, of class AvlTree.
     */
//    @Test
    public void testSubList()
    {
        // not impl
    }

    /**
     * Test of toArray method, of class AvlTree.
     */
    @Test
    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    public void testToArray_0args()
    {
        AvlTree<Integer> list = generateList();
        Object[] results = list.toArray();

        for (int i = 0; i < results.length; i++)
        {
            Assertions.assertEquals(SORTED_LIST[i], (Integer) results[i]);
        }

    }

    /**
     * Test of toArray method, of class AvlTree.
     */
    @Test
    public void testToArray_GenericType()
    {
        AvlTree<Integer> list = generateList();
        Integer[] test = new Integer[0];

        test = list.toArray(test);
        StringBuilder sb = new StringBuilder();

        for (Integer integer : test)
        {
            sb.append(integer.toString()).append(',');
        }

        Assertions.assertEquals(SORTED_STRING, sb.toString());
    }
}
