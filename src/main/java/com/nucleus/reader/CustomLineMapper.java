package com.nucleus.reader;

import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.nucleus.controller.domain.Player;

public class CustomLineMapper extends DefaultLineMapper<Player>{
	private LineTokenizer tokenizer;

	private FieldSetMapper<Player> fieldSetMapper;
    @Override
	public Player mapLine(String line, int lineNumber) throws Exception {
    	System.out.println(line+"*************************");
		return fieldSetMapper.mapFieldSet(tokenizer.tokenize(line));
	}

	public void setLineTokenizer(LineTokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public void setFieldSetMapper(FieldSetMapper<Player> fieldSetMapper) {
		this.fieldSetMapper = fieldSetMapper;
	}
	
}
