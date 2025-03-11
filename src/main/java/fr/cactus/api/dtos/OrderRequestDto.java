package fr.cactus.api.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private Integer userId;

    private Long clientTableId;

    private List<OrderRequestExtraDto> orderProductExtras;

}
