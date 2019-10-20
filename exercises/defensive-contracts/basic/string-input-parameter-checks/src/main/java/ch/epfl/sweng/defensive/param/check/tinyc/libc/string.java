package ch.epfl.sweng.defensive.param.check.tinyc.libc;

import ch.epfl.sweng.defensive.param.check.tinyc.fault.SegmentationFault;
import ch.epfl.sweng.defensive.param.check.tinyc.type.cstring;

public class string {
  private static void checkInputs(cstring destination, cstring source) {
    checkInputs(destination, source, 1);
  }
  private static void checkInputs(cstring destination, cstring source, int num) {
    if (destination == null) {
      throw new IllegalArgumentException("null destination");
    }
    if (source == null) {
      throw new IllegalArgumentException("null source");
    }
    if (num <= 0){
      throw new IllegalArgumentException("length <= 0");
    }
  }

  public static cstring strcpy(cstring destination, cstring source) throws SegmentationFault {
    checkInputs(source, destination);
    int i=0;
    while(source.get(i) != '\0'){
      destination.set(i, source.get(i));
      ++i;
    }
    destination.set(i+1, '\0');
    return destination;
  }

  public static cstring strncpy(cstring destination, cstring source, int num) throws SegmentationFault {
    for(int i=0; i<num; ++i){
      destination.set(i, source.get(i));
    }
    return destination;
  }

  public static cstring strcat(cstring destination, cstring source) throws SegmentationFault {
    checkInputs(destination, source);
    int i=0;
    while(source.get(i) == '\0'){
      ++i;
    }
    int j=0;
    while(destination.get(j) != '\0'){
      destination.set(i+j, source.get(j));
      ++j;
    }
    destination.set(i+j+1, '\0');
    return destination;
  }

  public static cstring strncat(cstring destination, cstring source, int num) throws SegmentationFault {
    checkInputs(destination, source, num);
    int i=0;
    while(source.get(i) == '\0'){
      ++i;
    }
    for(int j=0; j<num; ++j){
      destination.set(i+j, source.get(j));
    }
    destination.set(i+num, '\0');
    return destination;
  }

  public static int strlen(cstring str) {
    if (str == null){
      throw new IllegalArgumentException("String is null");
    }
    int i=0;
    while(str.get(i) != '\0'){
      ++i;
    }
    return i;
  }

  public static int strcmp(cstring str1, cstring str2) {
    checkInputs(str1, str2);
    int i=0;
    while(str1.get(i) == str2.get(i)) {
      if(str1.get(i) == '\0')
        return 0;
      ++i;
    }
    return str1.get(i)>str2.get(i) ? 1: -1;
  }

  public static int strncmp(cstring str1, cstring str2, int num) {
    checkInputs(str1, str2, num);
    int i=0;
    while(str1.get(i) == str2.get(i) || i == num) {
      if(str1.get(i) == '\0' || i == num)
        return 0;
      ++i;
    }
    return str1.get(i)>str2.get(i) ? 1: -1;
  }
}