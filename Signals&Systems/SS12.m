clear;
N=12;
n=[0:2*12-1];

x4=sin(2*pi*4*n/12);
x5=sin(2*pi*5*n/12);
x7=sin(2*pi*7*n/12);
x10=sin(2*pi*10*n/12);

figure;
stem(n,x4);xlabel('n');ylabel('x4[n]');
figure;
stem(n,x5);xlabel('n');ylabel('x5[n]');
figure;
stem(n,x7);xlabel('n');ylabel('x7[n]');
figure;
stem(n,x10);xlabel('n');ylabel('x10[n]');

clear all;
n=[0:9];

x1=sin(2*pi*1/5*n);
x2=sin(2*pi*2/5*n);
x4=sin(2*pi*4/5*n);
x6=sin(2*pi*6/5*n);

figure;
stem(n,x1);xlabel('n');ylabel('x1[n]');
figure;
stem(n,x2);xlabel('n');ylabel('x2[n]');
figure;
stem(n,x4);xlabel('n');ylabel('x4[n]');
figure;
stem(n,x6);xlabel('n');ylabel('x6[n]');

figure;
subplot(2,2,1);
stem(n,x1);xlabel('n');ylabel('x1[n]');
subplot(2,2,2);
stem(n,x2);xlabel('n');ylabel('x2[n]');
subplot(2,2,3);
stem(n,x4);xlabel('n');ylabel('x4[n]');
subplot(2,2,4);
stem(n,x6);xlabel('n');ylabel('x6[n]');

clear all;
n=[0:24];
x1=cos(2*pi*n/6)+2*cos(3*pi*n/6);
x2=2*cos(2*n/6)+cos(3*n/6);
x3=cos(2*pi*n/6)+3*cos(5*pi*n/12);

figure;
stem(n,x1);xlabel('n');ylabel('x1[n]');
figure;
stem(n,x2);xlabel('n');ylabel('x2[n]');
figure;
stem(n,x3);xlabel('n');ylabel('x3[n]');
