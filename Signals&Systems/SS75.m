%%
clc;
clear;
n=-31:32;
h=sinc(n-0.5);
stem(n,h);
xlabel('n');
ylabel('h[n]');
%%
clc;
clear;
n=-31:32;
B=[-1 0];
A=[pi -0.5*pi];
[H,w]=freqz(B,A,1024);
plot(w,abs(H));
title('h的幅值特性曲线')
%%
[tau,w] = grpdelay(h,1024);
%%
n = [-127:127];
x = sinc(pi.*n./8);
h = sin(pi.*(n-1/2))/pi.*(n-1/2);
y = conv(x,h);
stem(y);
xlabel('n');
ylabel('y');
title('具有单位脉冲响应为h的系统对x的响应');
%%
clc;
clear;
n=-127:127;
A=[1,0.75,1];
B=[1,-1];
x=sinc(n/8);
y=filter(B,A,x);
subplot(2,1,1);
stem(n,x);
title('系统输入');
subplot(2,1,2);
stem(n,y);
title('系统输出');
%%
n = [-127:127];
x = sinc(pi.*n./8);
h = sin(pi.*(n-1/2))/pi.*(n-1/2);
y = conv(x,h);
y2= conv(y,h);
subplot(2,1,1);
stem(y2);
xlabel('n');
ylabel('y2');
title('具有单位脉冲响应为h的系统对y的响应');
subplot(2,1,2);
stem(n,x);
xlabel('n');
ylabel('x');
title('系统输入x[n] = sinc(pi.*n./8)');
%%
n = [-127:127];
x = sinc(pi.*n./8);
h = sin(pi.*(n-1/2))/pi.*(n-1/2);
h2 = conv(h,h);
stem(h2);
xlabel('n');
ylabel('h2');
title('总系统的单位脉冲响应h2[n]=h1[n]*h1[n]');