package com.ukefu.webim.service.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ukefu.webim.web.model.CallInLost;
import com.ukefu.webim.web.model.Voicemail;

public interface VoicemailRepository extends JpaRepository<Voicemail, String>{
	
	
	public abstract Page<Voicemail> findAll(Pageable paramPageable);
	
	 public abstract Page<Voicemail> findByVoicetimeBetween(Date starttime,Date endtime,Pageable paramPageable);
	 @Transactional
	public abstract void deleteById(String id);
	 
	 public abstract  Voicemail findByVoicefilename(String voicefilename);

}
