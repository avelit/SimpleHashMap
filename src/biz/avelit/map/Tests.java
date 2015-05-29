package biz.avelit.map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Tests {
  //ключей типа int и значений типа long. Для упрощения размер внутренней хеш-таблицы может быть фиксированным.
  //Реализуйте операции put, get, size. Протестируйте правильность работы с помощью соответствующих Unit Tests.
  @Test
  public void size1() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    int result = map.size();
    //then
    int expectedResult = 1;
    assertEquals(expectedResult, result);
  }

  @Test
  public void size1_again() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    map.put(1,2l);
    int result = map.size();
    //then
    int expectedResult = 1;
    assertEquals(expectedResult, result);
  }

  @Test
  public void size2() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    map.put(2,2l);
    Integer result = map.size();
    //then
    Integer expectedResult = 2;
    assertEquals(expectedResult, result);
  }

  @Test
  public void get() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    map.put(2,2l);
    Long result = map.get(2);
    //then
    Long expectedResult = 2l;
    assertEquals(expectedResult, result);
  }

  @Test
  public void get_unknown() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    map.put(2,2l);
    Long result = map.get(3);
    //then
    Long expectedResult = null;
    assertEquals(expectedResult, result);
  }

  @Test
  public void get_when_hash_equal_previous_hash() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    map.put(101,2l);
    Long result = map.get(101);
    //then
    Long expectedResult = 2l;
    assertEquals(expectedResult, result);
  }

  @Test
  public void get_when_hash_equal_previous_2hashes() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    map.put(101,2l);
    map.put(201,3l);
    Long result = map.get(101);
    //then
    Long expectedResult = 2l;
    assertEquals(expectedResult, result);
  }

  @Test
  public void size_when_hash_equal_previous_2hashes_and_overwriting_node_and_get() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(1,1l);
    map.put(101,2l);
    map.put(201,3l);
    map.put(101,3l);

    map.get(101);

    map.put(101,4l);
    map.put(201,5l);
    Integer result = map.size();
    //then
    Integer expectedResult = 3;
    assertEquals(expectedResult, result);
  }

  @Test
  public void try_receive_exception() {
    //given
    SimpleHashMap map = new SimpleHashMap();
    //when
    map.put(99,1l);
    map.put(999,2l);
    Integer result = map.size();
    //then
    //we expect 2, but by the open adressing no more place at the end of array
    Integer expectedResult = 2;
    assertNotEquals(expectedResult, result);
  }
}
