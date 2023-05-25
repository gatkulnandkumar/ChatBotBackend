package com.nucsoft.controller;

import java.util.List;
import java.util.Map;

//import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.postgresql.util.PGobject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nucsoft.Model.ChatBot;
import com.nucsoft.Repository.chatBotRepository;
import com.nucsoft.Service.chatBotService;

@RestController
@RequestMapping("/chatBot")
public class ChatBotController {

	@Autowired
	private chatBotService chatbotService;

	@Autowired
	private chatBotRepository chatbotRepository;
//	private AppConfig appconfig;

	@GetMapping("")
	public List<ChatBot> getAllChatBot() {
		System.out.println("Get All data here ====>");
		return chatbotService.getAllChatBot();
	}

	@GetMapping("/{id}")
	public ChatBot getChatBotById(@PathVariable Long id) {
		System.out.println("Get ByID data here ====>");
		return chatbotService.getChatBotById(id);
	}

	@PostMapping("/insertData")
	public ChatBot createChatBot(@RequestBody Map<String, Object> chatbot) throws JsonProcessingException {
		System.out.println(chatbot);
		ChatBot bot = new ChatBot();
		bot.setMessage_type(chatbot.get("message_type").toString());
		bot.setMessage(chatbot.get("message").toString());
		bot.setContext_id(chatbot.get("context_id").toString());
		bot.setNext_action(chatbot.get("next_action").toString());
		bot.setExecution_detail(chatbot.get("execution_detail").toString());
		bot.setIssue_types(chatbot.get("issue_types").toString());
		bot.setPayload(chatbot.get("payload").toString());
//		System.out.println("bot is" + bot.toString());

//		return bot;
		return chatbotRepository.save(bot);
	}

	@PutMapping("/{id}")
	public ChatBot updateChatBot(@PathVariable Long id, @RequestBody Map<String, Object> chatbot) {
		ChatBot existingData = chatbotService.getChatBotById(id);

		existingData.setMessage_type(chatbot.get("message_type").toString());
		existingData.setMessage(chatbot.get("message").toString());
		existingData.setContext_id(chatbot.get("context_id").toString());
		existingData.setNext_action(chatbot.get("next_action").toString());
		existingData.setExecution_detail(chatbot.get("execution_detail").toString());
		existingData.setPayload(chatbot.get("payload").toString());
		existingData.setIssue_types(chatbot.get("issue_types").toString());

		return chatbotService.saveOrUpdateChatBot(existingData);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable Long id) {
		chatbotService.deleteChatBotById(id);
		return "Deleted::::" + id;
	}
}
