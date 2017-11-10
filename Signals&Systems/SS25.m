%%
clear;
close all;
a=1;
b=[1 -1 -1];
n=[0:5];

x1=[1 0 0 0 0 0];
x2=[0 1 0 0 0 0];
x3=x1+2*x2;

w1=filter(b,a,x1);
w2=filter(b,a,x2);
w3=filter(b,a,x3);
w4=w1+2*w2;

subplot(2,2,1);
stem(n,w1);xlabel('n');ylabel('w1');
subplot(2,2,2);
stem(n,w2);xlabel('n');ylabel('w2');
subplot(2,2,3);
stem(n,w3);xlabel('n');ylabel('w3');
subplot(2,2,4);
stem(n,w4);xlabel('n');ylabel('w1+2*w2');
%%
clear;
close all;

n=[0:5];

x1=[1 0 0 0 0 0];
x2=[0 1 0 0 0 0];
x3=x1+2*x2;

y1=cos(x1);
y2=cos(x2);
y3=cos(x3);
y4=y1+2*y2;

subplot(2,2,1);
stem(n,y1);xlabel('n');ylabel('y1');
subplot(2,2,2);
stem(n,y2);xlabel('n');ylabel('y2');
subplot(2,2,3);
stem(n,y3);xlabel('n');ylabel('y3');
subplot(2,2,4);
stem(n,y4);xlabel('n');ylabel('y1+2*y2');
%%
clear;
close all;

n=[0:5];

x1=[1 0 0 0 0 0];
x2=[0 1 0 0 0 0];
x3=x1+2*x2;

z1=n.*x1;
z2=n.*x2;
z3=n.*x3;
z4=z1+2*z2;

subplot(2,2,1);
stem(n,z1);xlabel('n');ylabel('z1');
subplot(2,2,2);
stem(n,z2);xlabel('n');ylabel('z2');
subplot(2,2,3);
stem(n,z3);xlabel('n');ylabel('z3');
subplot(2,2,4);
stem(n,z4);xlabel('n');ylabel('z1+2*z2');