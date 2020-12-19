package com.rly.algorithm.SCH;

import com.rly.algorithm.GO.GOalgorithmService;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/19 22:31
 */
public class SCHdata
{
	private SCHalgorithmService scHalgorithmService=new SCHalgorithmService();
	private List<Double> timedata;//时间失效数据
	private List<Double>fun;//概率密度函数
	private List<Double>F;//分布函数
	private List<Double>MTTF;//MTTF数据
	private List<Double>R;//可靠性函数
	private List<Double>U_x;//U图的x轴数据
	private List<Double>U_y;//U图的y轴数据
	private List<Double>Y_x;//U图的x轴数据
	private List<Double>Y_y;//U图的y轴数据
	public SCHdata(List<Double>in, double ux,double uy)
	{
		setTimedata(in);
		scHalgorithmService.init(in,ux,uy);
		setFun(scHalgorithmService.get_f());
		setF(scHalgorithmService.get_F());
		setR(scHalgorithmService.get_R());
		setMTTF(scHalgorithmService.get_MTTF());
		setU_x(scHalgorithmService.getu_xdata());
		setU_y(scHalgorithmService.getu_ydata());
		setY_x(scHalgorithmService.gety_xdata());
		setY_y(scHalgorithmService.gety_ydata());
	}

	public SCHalgorithmService getScHalgorithmService()
	{
		return scHalgorithmService;
	}

	public void setScHalgorithmService(SCHalgorithmService scHalgorithmService)
	{
		this.scHalgorithmService = scHalgorithmService;
	}

	public List<Double> getTimedata()
	{
		return timedata;
	}

	public void setTimedata(List<Double> timedata)
	{
		this.timedata = timedata;
	}

	public List<Double> getFun()
	{
		return fun;
	}

	public void setFun(List<Double> fun)
	{
		this.fun = fun;
	}

	public List<Double> getF()
	{
		return F;
	}

	public void setF(List<Double> f)
	{
		F = f;
	}

	public List<Double> getMTTF()
	{
		return MTTF;
	}

	public void setMTTF(List<Double> MTTF)
	{
		this.MTTF = MTTF;
	}

	public List<Double> getR()
	{
		return R;
	}

	public void setR(List<Double> r)
	{
		R = r;
	}

	public List<Double> getU_x()
	{
		return U_x;
	}

	public void setU_x(List<Double> u_x)
	{
		U_x = u_x;
	}

	public List<Double> getU_y()
	{
		return U_y;
	}

	public void setU_y(List<Double> u_y)
	{
		U_y = u_y;
	}

	public List<Double> getY_x()
	{
		return Y_x;
	}

	public void setY_x(List<Double> y_x)
	{
		Y_x = y_x;
	}

	public List<Double> getY_y()
	{
		return Y_y;
	}

	public void setY_y(List<Double> y_y)
	{
		Y_y = y_y;
	}
}
