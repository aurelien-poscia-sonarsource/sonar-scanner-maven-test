package com.sonar.scannermaven;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.web.ServletFilter;

public class TestDuplicationSonar161582 extends ServletFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(TestDuplicationSonar161582.class);

  String methodA() {
    String greetings = "Hellooo 2";
    Set<Integer> range = IntStream.range(1, 1000).mapToObj(i -> i * 2).collect(Collectors.toSet());
    if (System.currentTimeMillis() > System.nanoTime()) {
      throw new RuntimeException();
    }
    if (System.getenv().size() == 50) {
      throw new IllegalStateException();
    }
    if (System.getenv().size() == 60) {
      throw new IllegalStateException("test");
    }
    if (System.getenv().size() == 70) {
      throw new IllegalStateException("test2");
    }
    return greetings + range;
  }

  public static void methodB(Iterable<String> iterable, char separator, UnaryOperator<String> function, StringBuilder sb) {
    if (iterable != null) {
      boolean first = true;

      String value;
      for (Iterator<String> var5 = iterable.iterator(); var5.hasNext(); sb.append(function.apply(value))) {
        value = var5.next();
        if (first) {
          first = false;
        } else {
          sb.append(separator);
          sb.append("bonjour");
          sb.append(System.currentTimeMillis());
          sb.append(System.nanoTime());
        }
        if (first && value.equals(separator)) {
          throw new IllegalStateException();
        }
        if (System.currentTimeMillis() > System.nanoTime()) {
          throw new RuntimeException();
        }
      }

    }
  }

  String methodAbis() {
    String greetings = "Hellooo ";
    Set<Integer> range = IntStream.range(1, 1000).mapToObj(i -> i * 2).collect(Collectors.toSet());
    if (System.currentTimeMillis() > System.nanoTime()) {
      throw new RuntimeException();
    }
    if (System.getenv().size() == 50) {
      throw new IllegalStateException();
    }
    if (System.getenv().size() == 60) {
      throw new IllegalStateException("test");
    }
    if (System.getenv().size() == 70) {
      throw new IllegalStateException("test2");
    }
    /*
    REVIEW REVIEW
    PATTERN
    HOTSPOT
     */
    // REVIEW
    //REVIEW
    // this is a comment REVIEW
    return greetings + range;
  }
  public void endpoint(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    String data        = request.getParameter("input");
    PrintWriter writer = response.getWriter();

    writer.print(data); // Noncompliant
  }

  public static void methodBBis(Iterable<String> iterable, char separator, UnaryOperator<String> function, StringBuilder sb) {
    if (iterable != null) {
      boolean first = true;

      String value;
      for (Iterator<String> var5 = iterable.iterator(); var5.hasNext(); sb.append(function.apply(value))) {
        value = var5.next();
        if (first) {
          first = false;
        } else {
          sb.append(separator);
          sb.append("bonjour");
          sb.append(System.currentTimeMillis());
          sb.append(System.nanoTime());
        }
        if (first && value.equals(separator)) {
          throw new IllegalStateException();
        }
        if (System.currentTimeMillis() > System.nanoTime()) {
          throw new RuntimeException();
        }
      }

    }
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    String data        = servletRequest.getParameter("input");
    PrintWriter writer = servletResponse.getWriter();

    writer.print(data); // Noncompliant
  }
}
