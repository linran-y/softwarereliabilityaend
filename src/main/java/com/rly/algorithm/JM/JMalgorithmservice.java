package com.rly.algorithm.JM;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




/*
 *@auther ykw
 *@date 2020/12/15 21:20
 */
@Service
@Data
public class JMalgorithmservice
{
        private List<Double>t;//失效时间数据
        private double ex;
        private double ey;
        private double N,fie;//模型的未知参数，需要用极大似然法求出
        private int n;//样本数，其中t0为0,t1-tn才是失效数据
        private double p;//中间变量
        private double left,right,root;//中间变量
        private void calc_p()//计算p
        {
                double res=0;
                for(int i=1;i<=n;i++)
                {
                        res+=(i-1)*(t.get(i)-t.get(i-1));
                }
                res/=t.get(n);
                p=res;
        }
        private double calc_f(double N)//模型参数估计中的f函数
        {
                double ans=0;
                for(int i=1;i<=n;i++)
                {
                        ans+=1/(N-i-1)-n/(N-p);
                }
                return ans;
        }

        private void step_1()
        {
                calc_p();//先计算p
                if(p>(n-1)/2)
                {
                        left=n-1;
                        right=1;
                        step_2();
                }
        }
        private void step_2()
        {
                while(calc_f(right)>ey)
                {
                      left=right;right+=1;
                }
                if(-ex<calc_f(right)&&calc_f(right)<ey)
                {
                        root=right;
                        step_5();
                }
                else if(calc_f(right)<=-ex)
                {
                        step_3();
                }
        }
        private void step_3()
        {
                if(Math.abs(right-right)<ex)
                {
                        root=(left+right)/2;
                        step_5();
                }
                else if(Math.abs(right-right)>ex)
                {
                        root=(left+right)/2;
                        step_4();
                }
        }
        private void step_4()
        {
                if(calc_f(root)>ey)
                {
                        left=root;
                        step_3();
                }
                else if(-ey<calc_f(root)&&calc_f(root)<ey)
                {
                        step_5();
                }
                else
                {
                        right=root;
                        step_3();
                }
        }
        private void step_5()
        {
                N=root;
                double res=N*t.get(n);
                for(int i=1;i<=n;i++)
                {
                        res-=(i-1)*(t.get(i)-t.get(i-1));
                }
                fie=n/res;
        }
        private double getFun(int i)
        {
                return 1-Math.pow(Math.E,-fie*(N-i+1)*t.get(i));
        }
        public JMalgorithmservice()
        {
        }

        public void init(List<Double>in, double ex, double ey)//初始化函数
        {
                this.n=in.size();
                Collections.sort(in);
                this.t=in;
                t.add(0,0.0);
                this.ex=ex;this.ey=ey;
                step_1();//进行模型参数计算
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
                        double res=fie*(N-i+1)*Math.pow(Math.E,-fie*(N-i+1)*(t.get(i)-t.get(i-1)));
                        ans.add(res);
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
                        double res=1/(fie*(N-i+1));
                        ans.add(res);
                }
                ans.add(0,0.0);
                return ans;
        }
        public List<Double> getT()
        {
                return t;
        }

        public void setT(List<Double> t)
        {
                this.t = t;
        }

        public double getEx()
        {
                return ex;
        }

        public void setEx(double ex)
        {
                this.ex = ex;
        }

        public double getEy()
        {
                return ey;
        }

        public void setEy(double ey)
        {
                this.ey = ey;
        }

        public double getN()
        {
                return N;
        }

        public void setN(int n)
        {
                this.n = n;
        }

        public double getP()
        {
                return p;
        }

        public void setP(double p)
        {
                this.p = p;
        }

        public double getLeft()
        {
                return left;
        }

        public void setLeft(double left)
        {
                this.left = left;
        }

        public double getRight()
        {
                return right;
        }

        public void setRight(double right)
        {
                this.right = right;
        }

        public double getRoot()
        {
                return root;
        }

        public void setRoot(double root)
        {
                this.root = root;
        }

        public void setN(double n)
        {
                N = n;
        }

        public double getFie()
        {
                return fie;
        }

        public void setFie(double fie)
        {
                this.fie = fie;
        }
}
