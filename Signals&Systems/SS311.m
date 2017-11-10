%%
clear;
x1=sym('5*(exp(i*2*pi*t)+exp(-i*2*pi*t))+2*(exp(i*6*pi*t)+exp(-i*6*pi*t))');
x2=sym('i*(exp(i*pi*t)-exp(-i*pi*t))+(-1/2)*i*(exp(i*2*pi*t)-exp(-i*2*pi*t))+(1/4)*i*(exp(i*3*pi*t)-exp(-i*3*pi*t))+(-1/8)*i*(exp(i*4*pi*t)-exp(-i*4*pi*t))');
x3=sym('i*(exp(i*pi*t/2)-exp(-i*pi*t/2))+(1/2)*i*(exp(i*pi*t)-exp(-i*pi*t))+(1/4)*i*(exp(i*3/2*pi*t)-exp(-i*3/2*pi*t))+(1/8)*i*(exp(i*2*pi*t)-exp(-i*2*pi*t))');

figure;
ezplot(x1,[0:0.01:2]);xlabel('t');ylabel('x1(t)');

figure;
ezplot(x2,[0:0.01:4]);xlabel('t');ylabel('x2(t)');

figure;
ezplot(x3,[0:0.01:8]);xlabel('t');ylabel('x3(t)');
