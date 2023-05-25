package com.nucsoft.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nucsoft.Model.ChatBot;

 @Repository
public interface chatBotRepository extends JpaRepository<ChatBot, Long>{

}
