package com.nucsoft.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nucsoft.Model.ChatBot;
import com.nucsoft.Repository.chatBotRepository;

@Service
public class chatBotService {
	
	 @Autowired
	    private chatBotRepository chatbotRepository;
	 
	    public List<ChatBot> getAllChatBot() {
	        return chatbotRepository.findAll();
	    }
	 
	    public ChatBot getChatBotById(Long id) {
	        return chatbotRepository.findById(id).orElse(null);
	    }
	 
	    public ChatBot saveOrUpdateChatBot(ChatBot chatbot) {
	    	 System.out.println("chatbotRepository chatBot data here ====>"+chatbot);
	        return chatbotRepository.save(chatbot);
	    }
	 
	    public void deleteChatBotById(Long id) {
	    	chatbotRepository.deleteById(id);
	    }
	   

}
