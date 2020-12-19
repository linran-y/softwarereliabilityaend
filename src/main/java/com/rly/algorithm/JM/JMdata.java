package com.rly.algorithm.JM;

import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/18 17:21
 */
public class JMdata
{
	private JMalgorithmservice jMalgorithmservice=new JMalgorithmservice();
	private List<Double>timedata;//时间失效数据
	private List<Double>fun;//概率密度函数
	private List<Double>F;//分布函数
	private List<Double>MTTF;//MTTF数据
	private List<Double>R;//可靠性函数
	private List<Double>U_x;//U图的x轴数据
	private List<Double>U_y;//U图的y轴数据
	private List<Double>Y_x;//U图的x轴数据
	private List<Double>Y_y;//U图的y轴数据
	public JMdata(List<Double>in,double ex,double ey)
	{
		setTimedata(in);
		jMalgorithmservice.init(in,ex,ey);
		setFun(jMalgorithmservice.get_f());
		setF(jMalgorithmservice.get_F());
		setR(jMalgorithmservice.get_R());
		setMTTF(jMalgorithmservice.get_MTTF());
		setU_x(jMalgorithmservice.getu_xdata());
		setU_y(jMalgorithmservice.getu_ydata());
		setY_x(jMalgorithmservice.gety_xdata());
		setY_y(jMalgorithmservice.gety_ydata());
	}

	@Override
	public String toString()
	{
		return "JMdata{" +
				"jMalgorithmservice=" + jMalgorithmservice +
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

	public JMalgorithmservice getjMalgorithmservice()
	{
		return jMalgorithmservice;
	}

	public void setjMalgorithmservice(JMalgorithmservice jMalgorithmservice)
	{
		this.jMalgorithmservice = jMalgorithmservice;
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
}
