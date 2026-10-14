package com.challenge.orderservice.service;

import com.challenge.orderservice.entity.OrderItem;
import com.challenge.orderservice.repository.OrderRepository;
import com.challenge.orderservice.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public double calculateTotalRevenue() {
        List<OrderItem> items = Arrays.asList(
                new OrderItem(1L, "chocolate", 20, 5),
                new OrderItem(2L, "cake", 200, 2)

        );
       Order order = new Order("1", items, "101", "SUCCESS");

        double totalRevenue = order.getItems().stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();


        return totalRevenue;
    }

    public Map<String, List<Order>> groupOrdersByCustomer() {
        List<OrderItem> items = Arrays.asList(
                new OrderItem(1L, "chocolate", 20, 5),
                new OrderItem(2L, "cake", 200, 2)

        );
        List<Order> orderList = Arrays.asList(
                new Order("1", items, "101", "SUCCESS"),
                new Order("1", items, "102", "SUCCESS"),
                new Order("3", items, "103", "SUCCESS"),
                new Order("3", items, "104", "SUCCESS")
        );

        Map<String, List<Order>> groupMap = orderList.stream()
                .collect(Collectors.groupingBy(Order :: getCustomerId));
        groupMap.forEach((customer, list) ->
                System.out.println("customer: " + customer + "list: " +list));
        return groupMap;
    }

    public List<String> getTopSpentCustomers(int n) {
        List<OrderItem> items1 = Arrays.asList(
                new OrderItem(1L, "chocolate", 20, 5),
                new OrderItem(2L, "cake", 200, 2)

        );
        List<OrderItem> items2 = Arrays.asList(
                new OrderItem(1L, "chocolate", 200, 5),
                new OrderItem(2L, "cake", 200, 2)

        );
        List<Order> orderList = Arrays.asList(
                new Order("1", items1, "101", "SUCCESS"),
                new Order("1", items1, "102", "SUCCESS"),
                new Order("3", items2, "103", "SUCCESS"),
                new Order("3", items2, "104", "SUCCESS")
        );

        Map<String, List<Order>> groupMap = orderList.stream()
                .collect(Collectors.groupingBy(Order :: getCustomerId,
                        Collectors.maxBy(Comparator.comparingDouble())));



        return List.of();
    }
}
