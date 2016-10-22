package com.qk.practice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qk.practice.common.CacheProcessor;
import com.qk.practice.common.Constant;
import com.qk.practice.common.SubjectEnum;
import com.qk.practice.dao.IAnswerDao;
import com.qk.practice.dao.IPracticeDao;
import com.qk.practice.dao.IPracticeInstanceDao;
import com.qk.practice.dao.ISubjectDao;
import com.qk.practice.model.Practice;
import com.qk.practice.model.PracticeInstance;
import com.qk.practice.model.PracticeTag;
import com.qk.practice.model.Tag;
import com.qk.practice.service.IPracticeService;
import com.qk.practice.util.UUIDGenerator;
import com.qk.practice.util.Utils;

@Service("practiceService")
public class PracticeServiceImpl implements IPracticeService {

	private static Logger logger = Logger.getLogger(PracticeServiceImpl.class);

	@Autowired
	private IPracticeDao practiceDao;
	@Autowired
	private IPracticeInstanceDao practiceInstanceDao;
	@Autowired
	private IAnswerDao answerDao;
	@Autowired
	private ISubjectDao subjectDao;

	@Override
	public Practice getPracticeById(String practiceId) throws Exception {
		Practice practice = practiceDao.getPracticeById(practiceId);
		return practice;
	}

	@Override
	public List<Practice> getPractices(Practice practice) throws Exception {
		if (null == practice) {
			return practiceDao.getAllPractices();
		}
		return practiceDao.getPractices(practice);
	}

	@Override
	public String insertPractice(Practice practice) throws Exception {
		logger.info("===Start to insert Practice.");
		if (null == practice) {
			logger.debug("===Can't be inserted because Practice is null.");
			return Constant.FAILURE;
		}

		String lastModifiedBy = practice.getLastModifiedBy();

		logger.debug("===Start to insert Answer.");
		if (null == practice.getAnswer()) {
			logger.debug("===Can't be inserted because Answer is null.");
		} else {
			practice.getAnswer().setAnswerId(UUIDGenerator.getNewUUID());
			practice.getAnswer().setLastModifiedBy(lastModifiedBy);
			answerDao.insertAnswer(practice.getAnswer());
			logger.debug("===Inserted Answer: "
					+ practice.getAnswer().getAnswerId());
		}

		logger.debug("===Start to insert Subject.");
		if (Utils.isEmpty(practice.getSubjectId())) {
			// set a default subject
			logger.debug("===Set TBD as default subject because of no Subject specified.");
			practice.setSubjectId(CacheProcessor.CACHE_SUBJECT
					.get(SubjectEnum.TBD.name()));
		}

		logger.debug("===Start to insert Practice.");
		String practiceId = UUIDGenerator.getNewUUID();
		practice.setPracticeId(practiceId);
		practice.setCode(practiceId + "-" + practice.getTitle());
		practiceDao.insertPractice(practice);
		logger.debug("===Inserted Practice: " + practiceId);

		logger.debug("===Start to insert Practice Tag.");
		if (Utils.isEmpty(practice.getTags())) {
			logger.debug("===Can't be inserted Practice Tag because Tags is null.");
		} else {
			List<PracticeTag> ptList = new ArrayList<PracticeTag>();
			for (Tag tag : practice.getTags()) {
				PracticeTag pt = new PracticeTag();
				pt.setIsDelete(Constant.NO);
				pt.setLastModifiedBy(lastModifiedBy);
				pt.setPracticeId(practiceId);
				pt.setTagId(tag.getTagId());
				pt.setPracticeTagId(UUIDGenerator.getNewUUID());
				ptList.add(pt);
			}
			practiceDao.insertPracticeTags(ptList);
		}
		logger.debug("===Inserted Practice Tags.");

		logger.info("===End to insert Practice.");
		return Constant.SUCCESS;
	}

	@Override
	public String deletePractice(Practice practice) throws Exception {
		logger.info("===Start to delete Practice.");
		// delete practice tag
		if (null == practice) {
			logger.debug("===Can't be delete because practice is null.");
			return Constant.FAILURE;
		}
		practiceDao.deletePracticeById(practice);

		logger.info("===End to delete Practice.");
		return Constant.SUCCESS;
	}

	@Override
	public String deletePractices(String practiceIds, String lastModifiedBy)
			throws Exception {
		if (Utils.isEmpty(practiceIds.trim())) {
			logger.debug("===Can't be delete because practiceIds is null.");
			return Constant.FAILURE;
		}
		logger.info("===Start to delete Practices by practiceIds:" + practiceIds);
		String[] ids = practiceIds.split(",");
		List<Practice> ps = new ArrayList<Practice>();
		for (String id : ids) {
			Practice p = new Practice();
			p.setPracticeId(id.trim());
			p.setLastModifiedBy(lastModifiedBy);
			ps.add(p);
		}
		practiceDao.deletePracticesById(ps);
		logger.info("===End to delete Practices.");
		return Constant.SUCCESS;
	}

	@Override
	public String updatePractice(Practice practice) throws Exception {
		logger.info("===Start update Practice.");

		// update practice tag
		if (!Utils.isEmpty(practice.getTags())) {
			updatePracticeTag(practice);
		} else {
			// delete all practice tag for the practice
			PracticeTag pt = new PracticeTag();
			pt.setPracticeId(practice.getPracticeId());
			pt.setLastModifiedBy(practice.getLastModifiedBy());
			practiceDao.deletePracticeTagById(pt);
		}
		logger.debug("===Completed PracticeTag update with practiceId: "
				+ practice.getPracticeId());

		// update answer
		if (null != practice.getAnswer()) {
			practice.getAnswer()
					.setLastModifiedBy(practice.getLastModifiedBy());
			answerDao.updateAnswerById(practice.getAnswer());
			logger.debug("===Completed Answer update with practiceId: "
					+ practice.getPracticeId());
		}

		// update practice
		practiceDao.updatePracticeById(practice);
		logger.debug("===Completed Practice update with practiceId: "
				+ practice.getPracticeId());

		logger.info("===End update Practice.");
		return Constant.SUCCESS;
	}

	@Override
	public String insertPracticeInstance(PracticeInstance practiceInstance)
			throws Exception {
		logger.info("===Start insert PracticeInstance.");
		if (null == practiceInstance) {
			logger.debug("===Can't be inserted because PracticeInstance is null.");
			return Constant.FAILURE;
		}
		logger.debug("===Insert Practice Instance.");
		practiceInstance.setPracticeInstanceId(UUIDGenerator.getNewUUID());
		practiceInstanceDao.insertPracticeInstance(practiceInstance);

		logger.info("===End insert PracticeInstance.");
		return Constant.SUCCESS;
	}

	@Override
	public String updatePracticeInstance(PracticeInstance practiceInstance)
			throws Exception {
		logger.info("===Start update PracticeInstance.");
		if (null == practiceInstance) {
			logger.debug("===Can't be updated because PracticeInstance is null.");
			return Constant.FAILURE;
		}
		practiceInstanceDao.updatePracticeInstanceById(practiceInstance);
		logger.debug("===Updated Practice Instance: "
				+ practiceInstance.getPracticeId());

		logger.info("===End update PracticeInstance.");
		return Constant.SUCCESS;
	}

	/**
	 * Update PracticeTag
	 * 
	 * @param Practice
	 *            practice
	 * @return SUCCESS or FAILURE
	 */
	private String updatePracticeTag(Practice practice) throws Exception {
		logger.info("===Start update PracticeTag.");
		List<Tag> tags = practice.getTags();
		List<PracticeTag> pts = new ArrayList<PracticeTag>();
		for (Tag tag : tags) {
			if (!Utils.isEmpty(tag.getTagId())) {
				PracticeTag pt = new PracticeTag();
				pt.setPracticeId(practice.getPracticeId());
				pt.setTagId(tag.getTagId());
				pt.setLastModifiedBy(practice.getLastModifiedBy());
				pt.setIsDelete(Constant.NO);
				pts.add(pt);
			}
		}

		String practiceId = practice.getPracticeId();
		List<PracticeTag> beforeUpdatePts = practiceDao
				.getPracticeTagsById(practiceId);
		List<PracticeTag> addPts = new ArrayList<PracticeTag>();
		List<PracticeTag> updatePts = new ArrayList<PracticeTag>();
		if (Utils.isEmpty(beforeUpdatePts)) {
			addPts.addAll(pts);
		} else {
			Map<String, PracticeTag> beforeUpdatePtsMap = getPracticeTagMap(beforeUpdatePts);
			for (PracticeTag temp : pts) {
				if (null == beforeUpdatePtsMap.get(temp.getTagId())) {
					temp.setPracticeTagId(UUIDGenerator.getNewUUID());
					addPts.add(temp);
				} else {
					if (beforeUpdatePtsMap.get(temp.getTagId()).getIsDelete()
							.equals(Constant.YES)) {
						updatePts.add(temp);
					}
					beforeUpdatePtsMap.remove(temp.getTagId());
				}
			}
			// the rest practice tag needs be deleted.
			if (beforeUpdatePtsMap.size() != 0) {
				for (String temp : beforeUpdatePtsMap.keySet()) {
					PracticeTag pt = beforeUpdatePtsMap.get(temp);
					if (pt.getIsDelete().equals(Constant.NO)) {
						pt.setIsDelete(Constant.YES);
						pt.setLastModifiedBy(practice.getLastModifiedBy());
						updatePts.add(pt);
					}
				}
			}
		}
		if (!Utils.isEmpty(updatePts)) {
			practiceDao.updatePracticeTags(updatePts);
		}
		if (!Utils.isEmpty(addPts)) {
			practiceDao.insertPracticeTags(addPts);
		}
		logger.info("===End update PracticeTag.");

		return Constant.SUCCESS;
	}

	/**
	 * Get map of <tagId, practiceTag>
	 * 
	 * @param pts
	 * @return map <tagId, practiceTag>
	 */
	private Map<String, PracticeTag> getPracticeTagMap(List<PracticeTag> pts) {
		if (Utils.isEmpty(pts)) {
			return null;
		}
		Map<String, PracticeTag> ptMap = new HashMap<String, PracticeTag>();
		for (PracticeTag temp : pts) {
			ptMap.put(temp.getTagId(), temp);
		}
		return ptMap;
	}

}
