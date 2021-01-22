package com.nucleus.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nucleus.controller.domain.Player;

public class CustomFileProcessor implements ItemProcessor<Player, Player> {

	public Player process(Player item) throws Exception {
		System.out.println("Processor*************");
		return item;
	}

}
