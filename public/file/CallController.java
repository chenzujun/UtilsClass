package com.ukefu.webim.web.handler.apps.call;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ukefu.util.CommonUtils;
import com.ukefu.util.Menu;
import com.ukefu.webim.service.repository.CallInLostRepository;
import com.ukefu.webim.service.repository.CallInRecordRepository;
import com.ukefu.webim.service.repository.CallOutRecordNewRepository;
import com.ukefu.webim.service.repository.CallTextRepository;
import com.ukefu.webim.service.repository.ReprotContactstatRepository;
import com.ukefu.webim.service.repository.SatisfactionRepository;
import com.ukefu.webim.service.repository.VoicemailRepository;
import com.ukefu.webim.service.repository.WorkerServiceRepository;
import com.ukefu.webim.web.handler.Handler;
import com.ukefu.webim.web.model.CallInLost;
import com.ukefu.webim.web.model.CallInRecord;
import com.ukefu.webim.web.model.CallOutRecordNew;
import com.ukefu.webim.web.model.CallText;
import com.ukefu.webim.web.model.ReprotContactstat;
import com.ukefu.webim.web.model.Satisfaction;
import com.ukefu.webim.web.model.Voicemail;
import com.ukefu.webim.web.model.WorkerService;
@Controller
@RequestMapping("/call")
public class CallController extends Handler {

	@Autowired
	private SatisfactionRepository satisfactionRepository ;
	@Autowired
	private CallInRecordRepository callInRecordRepository;
	@Autowired
	private CallOutRecordNewRepository callOutRecordNewRepository;
	@Autowired
	private CallInLostRepository callInLostRepository;
	@Autowired
	private CallTextRepository callTextRepository;
	@Autowired
	private ReprotContactstatRepository reprotContactstatRepository;
	@Autowired
	private WorkerServiceRepository workerServiceRepository;
	@Autowired
	private VoicemailRepository voicemaillRepository;
	
	   @RequestMapping("/calllist")
	    @Menu(type = "call" , subtype = "calllist" , admin= true)
	    public ModelAndView calllist(ModelMap map , HttpServletRequest request) {
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/calllist"));
		   //获取所有评价的满意度
		   Page<Satisfaction> findAll = satisfactionRepository.findAll(new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "callDate"));
		 
		   view.addObject("satisfactionList", findAll);
	    	return view;
	    }
	   
	   @RequestMapping("/callinlist")
	    @Menu(type = "call" , subtype = "callinlist" , admin= true)
	   public ModelAndView callinlist( HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/callinlist"));
		   Page<CallInRecord> findAll = callInRecordRepository.findAll(new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "callInBeginTime"));
		   view.addObject("CallInRecordList", findAll);
		   return view;
	   }
	   
	   
	   @RequestMapping("/callin/find")
	   @Menu(type = "call" , subtype = "callin" , admin= true)
	   public ModelAndView callinfind( HttpServletRequest request) throws Exception{
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/callinlist"));
		   String starttime = request.getParameter("starttime");
		   String endtime = request.getParameter("endtime");
		   Page<CallInRecord> findAll = callInRecordRepository.findByCallInBeginTimeBetween(CommonUtils.parseDateFormStr(starttime),CommonUtils.parseDateFormStr(endtime),new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "callInBeginTime"));
		   view.addObject("CallInRecordList", findAll);
		   return view;
	   }
	   
	   @RequestMapping("/calloutlist")
	   @Menu(type = "call" , subtype = "calloutlist" , admin= true)
	   public ModelAndView calloutlist(HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/calloutlist"));
		   Page<CallOutRecordNew> findAll = callOutRecordNewRepository.findAll(new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "callOutTime"));
		   view.addObject("CallOutRecordNewList", findAll);
		   return view;
	   }
	   
	   @RequestMapping("/callout/find")
	   @Menu(type = "call" , subtype = "callout" , admin= true)
	   public ModelAndView calloutfind(HttpServletRequest request) throws Exception{
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/calloutlist"));
		   String starttime = request.getParameter("starttime");
		   String endtime = request.getParameter("endtime");
		   Page<CallOutRecordNew> findAll = callOutRecordNewRepository.findByCallOutTimeBetween(CommonUtils.parseDateFormStr(starttime),CommonUtils.parseDateFormStr(endtime),new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "callOutTime"));
		   view.addObject("CallOutRecordNewList", findAll);
		   return view;
	   }
	   @RequestMapping("/calllostlist")
	   @Menu(type = "call" , subtype = "calllostlist" , admin= true)
	   public ModelAndView calllostlist(HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/calllostlist"));
		   Page<CallInLost> findAll = callInLostRepository.findAll(new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "callInTime"));
		   view.addObject("CallInLostList", findAll);

		   return view;
	   }
	   @RequestMapping("/calllost/find")
	   @Menu(type = "call" , subtype = "calllostlist" , admin= true)
	   public ModelAndView calllostfind(HttpServletRequest request) throws Exception{
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/calllostlist"));
		   String starttime = request.getParameter("starttime");
		   String endtime = request.getParameter("endtime");
		   Page<CallInLost> findAll = callInLostRepository.findByCallInTimeBetween(CommonUtils.parseDateFormStr(starttime),CommonUtils.parseDateFormStr(endtime),new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "callInTime"));
		   view.addObject("CallInLostList", findAll);
		   return view;
	   }
	   
	   @RequestMapping("/calltextlist")
	   @Menu(type = "call" , subtype = "calltextlist" , admin= true)
	   public ModelAndView calltextlist(HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/calltextlist"));
		   Page<CallText> findAll = callTextRepository.findAll(new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "creattime"));
		   view.addObject("CallTextList", findAll);
		   return view;
	   }
	   
	   @RequestMapping("/reprotcontactstat")
	   @Menu(type = "call" , subtype = "reprotcontactstat" , admin= true)
	   public ModelAndView reprotcontactstat(HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/reprotcontactstatlist"));

		   return view;
	   }
	   
	   @RequestMapping("/reprotcontactstat/find")
	   @Menu(type = "call" , subtype = "reprotcontactstat" , admin= true)
	   public ModelAndView reprotcontactstatfind(HttpServletRequest request) throws Exception{
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/reprotcontactstatlist"));
		   int callType;
		   List<ReprotContactstat> findAll = null;
		   try {
			   String startDateStr = request.getParameter("startDate");
			   String endDateStr = request.getParameter("endDate");
			   String callTypeStr = request.getParameter("callType");
			   callType = Integer.parseInt(callTypeStr);
			   
			   view.addObject("startDate", startDateStr);
			   view.addObject("endDate", endDateStr);
			   view.addObject("callType", callTypeStr);
			   
			   findAll = reprotContactstatRepository.findReprotContactstat(callType, startDateStr,endDateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		   view.addObject("ReprotContactstatList", findAll);

		   return view;
	   }
	   
	   @RequestMapping("/workerservice")
	   @Menu(type = "call" , subtype = "workerservice" , admin= true)
	   public ModelAndView workerservice(HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/workerservicelist"));
		   
		   return view;
	   }
	   
	   /*语音留言*/
	   
	   @RequestMapping("/workerservice/find")
	   @Menu(type = "call" , subtype = "workerservice" , admin= true)
	   public ModelAndView workerservicefind(HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/workerservicelist"));
		   List<WorkerService> findAll = null;
		   try {
			   String startDateStr = request.getParameter("startDate");
			   String endDateStr = request.getParameter("endDate");
			   
			   view.addObject("startDate", startDateStr);
			   view.addObject("endDate", endDateStr);
			   
			   findAll = workerServiceRepository.findReprotContactstat(startDateStr, endDateStr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		   view.addObject("workerserviceList", findAll);
		   
		   return view;
	   }
	   
	   @RequestMapping("/voicemaillist")
	   @Menu(type = "call" , subtype = "voicemaillist" , admin= true)
	   public ModelAndView voicemaillist(HttpServletRequest request){
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/voicemaillist"));
		   Page<Voicemail> findAll= voicemaillRepository.findAll(new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "voicetime"));
		   view.addObject("voicemaillList", findAll);
		   return view;
	   }
	   /*语音留言查询**/
	   @RequestMapping("/voicemail/find")
	   @Menu(type = "call" , subtype = "voicemail" , admin= true)
	   public ModelAndView voicemailfind(HttpServletRequest request) throws Exception{
		   ModelAndView view =request(super.createAppsTempletResponse("/apps/call/voicemaillist"));
		   String starttime = request.getParameter("starttime");
		   String endtime = request.getParameter("endtime");
		   Page<Voicemail> findAll = voicemaillRepository.findByVoicetimeBetween(CommonUtils.parseDateFormStr(starttime),CommonUtils.parseDateFormStr(endtime),new PageRequest(super.getP(request), super.getPs(request), Direction.DESC , "voicetime"));
		   view.addObject("voicemaillList", findAll);
		   return view;
	   }
	   
	   /*语音留言删除**/
	   @RequestMapping("/delete/voicemail")
	   @Menu(type = "call" , subtype = "delete" , admin= true)
	   public ModelAndView deletevoicemail(HttpServletRequest request) throws Exception{
		   String id = request.getParameter("id");
		   voicemaillRepository.deleteById(id);
		   return request(super
					.createRequestPageTempletResponse("redirect:/call/voicemaillist.html"));
	   }

}
