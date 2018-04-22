package com.gasq.bdp.logn.model;
import java.math.BigDecimal;
import java.util.ArrayList;
/**  
* 类说明   返点描述类
*  
* @author laody 
* @date 2017年12月5日
*/
import java.util.List;
public class ScoreDescribe extends BaseBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3131155897745415285L;
	/**
	 * 返点金额
	 */
	private BigDecimal  money;
	/**
	 * 返点用户 按照层级由小到大
	 */
	private List<TUser> scoreUsers;
	
	/**
	 * level 信息和折扣
	 */
	private List<TUserShareRule> scoreLevels;
	
	public void addScoreLevels(TUserShareRule sr){
		if(scoreLevels==null){
			if(level==null){
				scoreLevels=new ArrayList<>();
			}else{
				scoreLevels=new ArrayList<>(level);	
			}
			scoreLevels.add(sr);
		}else{
			scoreLevels.add(sr);
		}
	}
	
	public void addScoreUsers(TUser ur){
		if(scoreUsers==null){
			if(level==null){
				scoreUsers=new ArrayList<>();
			}else{
				scoreUsers=new ArrayList<>(level);	
			}
			scoreUsers.add(ur);
		}else{
			scoreUsers.add(ur);
		}
	}
	
	public List<TUserShareRule> getScoreLevels() {
		return scoreLevels;
	}

	public void setScoreLevels(List<TUserShareRule> scoreLevels) {
		this.scoreLevels = scoreLevels;
	}

	/**
	 * 消费用户
	 */
	private Long userId;

	
	/**
	 * 拥有层级
	 */
	private Integer level;
	
	
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public List<TUser> getScoreUsers() {
		return scoreUsers;
	}

	public void setScoreUsers(List<TUser> scoreUsers) {
		this.scoreUsers = scoreUsers;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
