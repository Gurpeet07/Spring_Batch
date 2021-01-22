package com.nucleus.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.nucleus.controller.domain.Player;
import com.nucleus.domainobject.PlayerEntity;

public class CustomFileWriter implements ItemWriter<Player> {
	@Autowired
	HibernateTemplate hibernateTemplate;

	public void write(List<? extends Player> items) throws Exception {
		System.out.println("Writer**********");
		for (Player player : items) {
			PlayerEntity playerEntity = new PlayerEntity();
			BeanUtils.copyProperties(player, playerEntity);
			hibernateTemplate.save(playerEntity);
		}
	}

}
