package com.example.demo.domain.player;

import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private Integer playerId = new Random().nextInt(Integer.MAX_VALUE);
}
