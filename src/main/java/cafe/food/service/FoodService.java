package cafe.food.service;

import cafe.food.domain.food.Food;
import cafe.food.repository.FoodRepository;
import cafe.food.response.ResFood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public Long save(Food food) {
        Food save = foodRepository.save(food);
        return save.getId();
    }

    public Food findById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    public Food findByName(String name) {
        return foodRepository.findByName(name).orElse(null);
    }

    public Food findByNameWithOrderFood(String name) {
        return foodRepository.findByNameWithOrderFood(name).orElse(null);
    }

    public List<Food> foodList() {
        return foodRepository.findAll();
    }

    @Transactional
    public Food editName(Long id, String name) {
        foodRepository.editName(id, name);
        return foodRepository.findById(id).orElse(null);
    }

    @Transactional
    public Food editPrice(Long id, int price) {
        foodRepository.editPrice(id, price);
        return foodRepository.findById(id).orElse(null);
    }

}
