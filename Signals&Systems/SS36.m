%%
clear
t=linspace(-1,1,1000);
y=0.5*(exp(i*2*pi*t)+exp(-i*2*pi*t));
plot(t,y);xlabel('t');ylabel('y(t)');