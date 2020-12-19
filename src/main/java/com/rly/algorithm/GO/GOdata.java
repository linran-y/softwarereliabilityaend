package com.rly.algorithm.GO;

import com.rly.algorithm.JM.JMalgorithmservice;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/18 17:21
 */
public class GOdata
{
	private GOalgorithmService gOalgorithmService=new GOalgorithmService();
	private List<Double>timedata;//时间失效数据
	private List<Double>fun;//概率密度函数
	private List<Double>F;//分布函数
	private List<Double>MTTF;//MTTF数据
	private List<Double>R;//可靠性函数
	private List<Double>U_x;//U图的x轴数据
	private List<Double>U_y;//U图的y轴数据
	private List<Double>Y_x;//U图的x轴数据
	private List<Double>Y_y;//U图的y轴数据
	public GOdata(List<Double>in, double zeta)
	{
		setTimedata(in);
		gOalgorithmService.init(in,zeta);
		setFun(gOalgorithmService.get_f());
		setF(gOalgorithmService.get_F());
		setR(gOalgorithmService.get_R());
		setMTTF(gOalgorithmService.get_MTTF());
		setU_x(gOalgorithmService.getu_xdata());
		setU_y(gOalgorithmService.getu_ydata());
		setY_x(gOalgorithmService.gety_xdata());
		setY_y(gOalgorithmService.gety_ydata());
	}

	public GOdata()
	{
	}

	@Override
	public String toString()
	{
		return "GOdata{" +
				"gOalgorithmService=" + gOalgorithmService +
				", timedata=" + timedata +
				", fun=" + fun +
				", F=" + F +
				", MTTF=" + MTTF +
				", R=" + R +
				", U_x=" + U_x +
				", U_y=" + U_y +
				", Y_x=" + Y_x +
				", Y_y=" + Y_y +
				'}';
	}

	public GOalgorithmService getgOalgorithmService()
	{
		return gOalgorithmService;
	}

	public void setgOalgorithmService(GOalgorithmService gOalgorithmService)
	{
		this.gOalgorithmService = gOalgorithmService;
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
