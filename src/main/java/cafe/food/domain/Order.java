package cafe.food.domain;

import cafe.food.domain.food.OrderFood;
import cafe.food.domain.member.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @NotNull
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderFood> orderFoods = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Setter
    private Status orderStatus = Status.ORDER;

    private LocalDateTime createAT = LocalDateTime.now();

    @Builder
    public Order(Member member) {
        this.member = member;
    }

    public void addOrderFood(OrderFood orderFood) {
        this.orderFoods.add(orderFood);
    }
}
