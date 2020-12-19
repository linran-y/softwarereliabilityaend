package com.rly.algorithm.SCH;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *@auther ykw
 *@date 2020/12/19 22:03
 */
@Service
public class SCHalgorithmService
{
	private List<Double> t;//时间失效数据
	private int n;//样本数
	private double ux;//给定的误差
	private double uy;//给定的误差
	private double alpha,beta;//待求参数
	private double xl,xr,xx,xm;//中间变量
	private void step_1()
	{
		xl=0.0;
		xr=1.0;
		double res=0;
		for(int j=0;j<n-1;j++)res+=t.get(j)-n*t.get(j);
		double q=0;
		for(int i=1;i<=n-1;i++)
		{
			q+=res*(t.get(i+1)-t.get(i));
		}
		if(q>0)step_5();
		else if(q==0)step_4();
	}
	private double P(double x)
	{
		double ans=0.0;
		for(int i=0;i<=n-1;i++)
		{
			double res=0;
			for(int j=0;j<=n-1;j++)
			{
				res+=t.get(j)-n*t.get(i);
			}
			ans+=res*(t.get(i+1)-t.get(i))*Math.pow(x,t.get(i));
		}
		return ans;
	}
	private void step_2()
	{
		xm=(xl+xr)/2;
		double pm=P(xm);
		if(-uy<=pm&&pm<=uy)
		{
			xx=xm;step_4();
		}
		else if(pm>uy)
		{
			xl=xm;
		}
		else if(pm<-uy)
		{
			xr=xm;
		}
		step_3();
	}
	private void step_3()
	{
		if(Math.abs(xr-xl)>ux)
		{
			step_2();
		}
		else
		{
			xx=(xl+xr)/2;
			step_4();
		}
	}
	private void step_4()
	{
		beta=-Math.log(xx);
		for(int i=0;i<=n-1;i++)
		{
			alpha+=Math.pow(Math.E,-beta*t.get(i))*(t.get(i+1)-t.get(i));
		}
		alpha=n/alpha;
	}
	private void step_5(){}

	public double funcfm(int i)
	{				//f(x)概率密度函数
		return alpha*Math.pow(Math.E,-beta*t.get(i));
	}
	public double getFun(int i)
	{				//F(x)概率分布函数
		return Math.abs(-alpha/beta*(Math.pow(Math.E,-beta*t.get(i))-1));
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


	void init(List<Double>in,double ux,double uy)
	{
		this.alpha=0.1;this.beta=0.1;
		this.n=in.size();
		Collections.sort(in);
		this.t=in;
		t.add(0,0.0);
		this.ux=ux;
		this.uy=uy;
		step_1();//进行模型参数计算
	}
}
