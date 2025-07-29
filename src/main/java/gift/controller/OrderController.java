package gift.controller;

import gift.annotation.LoginMember;
import gift.dto.LoginMemberDto;
import gift.dto.OrderRequest;
import gift.dto.OrderResponse;
import gift.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> order(@Valid @RequestBody OrderRequest request,
        @LoginMember LoginMemberDto memberDto) {

        OrderResponse response = orderService.order(request, memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
