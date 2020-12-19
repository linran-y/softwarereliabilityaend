package com.rly.algorithm.GO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/19 20:27
 */
@Service
public class GOalgorithmService
{

	private List<Double> t;//时间失效数据
	private int n;//样本数
	private double zeta;

	private double D;//中间变量
	private double xl,xr,xm;//中间变量
	private double a,b;//要求的参数
	private void step_1()
	{
		D=0.0;
		for(int i=1;i<=n;i++)
		{
			D+=t.get(i);
		}
		D/=(n*t.get(n));
		if(0<D&&D<0.5)
		{
			xl=(1-2*D)/2;
			xr=1/D;
			step_2();
		}
		else
			step_5();
	}
	private void step_2()
	{
		xm=(xl+xr)/2;
		if(Math.abs(xl-xr)<zeta)
			step_4();
		else
			step_3();
	}
	private void step_3()
	{
		double f=(1-D*xm)*Math.pow(Math.E,xm)+(D-1)*xm-1;
		if(f>zeta)
		{
			xl=xm;
			step_2();
		}
		else if(f<-zeta)
		{
			xr=xm;
			step_2();
		}
	}
	private void step_4()
	{
		b=xm/t.get(n);
		a=n/(1-Math.pow(Math.E,-b*t.get(n)));
	}
	private void step_5(){}
	private double M(double x)
	{
		return a*(1-Math.pow(Math.E,-b*x));
	}
	public double funcfm(int i) {				//f(x)概率密度函数
		double temp,temp2;
		double x=t.get(i);
		temp = this.a*(1.0-Math.pow(Math.E, -this.b*x));
		temp2 = Math.pow(Math.E, -temp);
		temp2 = temp2 * Math.pow(temp, i);
		for(int j=i; j>0; j--)
			temp2 = temp2/(double)j;
		temp2 = temp2 / 1.0;
		return temp2;
	}
	public double getFun(int i) {				//F(x)概率分布函数
		double temp,temp2;
		double x=t.get(i);
		temp = this.a*(1.0-Math.pow(Math.E, -this.b*t.get(i-1)));
		temp2 = -temp*Math.pow(Math.E, -this.b*t.get(i));
		temp2 = 1-Math.pow(Math.E, temp2);
		return temp2;
	}
	public List<Double>getu_xdata()//取得U图x轴坐标
	{
		List<Double>ans=new ArrayList<Double>();
		ans.add(0.0);
		for(int i=1;i<=n;i++)
		{
			ans.add(getFun(i));
		}
		Collections.sort(ans);
		return ans;
	}
	public List<Double>getu_ydata()//获取U图y轴数据
	{
		List<Double>ans=new ArrayList<Double>();
		ans.add(0.0);

		for(int i=1;i<=n;i++)
		{
			ans.add((double)((double)i/(double)n));

		}

		return ans;
	}
	public List<Double>gety_xdata()//获取Y图x轴数据
	{
		List<Double>ans=new ArrayList<Double>();

		List<Double>u=getu_xdata();
		List<Double>nu=new ArrayList<Double>();
		for(int i=0;i<u.size();i++)
		{
			double res=u.get(i);
			if(res==1.0)
				res=0.9999999;
			nu.add(Math.log(1-res));
		}
		double sum=0;
		for (Double aDouble : nu)sum+=aDouble;
		double res=0;
		for(int i=0;i<nu.size();i++)
		{
			res+=nu.get(i);
			ans.add(res/sum);
		}
		return ans;
	}
	public List<Double>gety_ydata()//获取Y图y轴数据
	{
		List<Double>ans=new ArrayList<Double>();
		ans.add(0.0);
		for(int i=1;i<n;i++)
		{
			ans.add((double)((double)i/(double)n));
		}
		ans.add(1.0);
		return ans;
	}
	public List<Double>get_f()//取得概率密度函数
	{
		List<Double> ans=new ArrayList<Double>();
		for(int i=1;i<=n;i++)
		{
			ans.add(funcfm(i));
		}
		ans.add(0,0.0);
		return ans;
	}
	public List<Double>get_F()//取得分布函数
	{
		List<Double> fun = get_f();
		double sum=0;
		for (Double aDouble : fun)
		{
			sum+=aDouble;
		}
		List<Double> ans=new ArrayList<Double>();
		double al=0;
		for(int i=0;i<n;i++)
		{
			al+=fun.get(i);
			//double res=1-Math.pow(Math.E,-fie*(N-i+1)*(t.get(i)-t.get(i-1)));
			ans.add(al/sum);
		}
		ans.add(0,0.0);
		return ans;
	}
	public List<Double>get_R()//取得可靠性函数
	{
		List<Double> F = get_F();
		List<Double> ans=new ArrayList<Double>();
		for (Double aDouble :F)
		{
			ans.add(1-aDouble);
		}
		return ans;
	}
	public List<Double>get_MTTF()//取得MTTF函数
	{
		List<Double> ans=new ArrayList<Double>();
		for(int i=1;i<=n;i++)
		{
			double res=funcfm(i);
			ans.add(res);
		}
		ans.add(0,0.0);
		return ans;
	}


	void init(List<Double>in,double zeta)
	{
		this.n=in.size();
		Collections.sort(in);
		this.t=in;
		t.add(0,0.0);
		this.zeta=zeta;
		step_1();//进行模型参数计算
	}
	public GOalgorithmService()
	{
	}

}
