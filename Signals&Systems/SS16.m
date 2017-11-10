clear all;
x=sym('sin(2*pi*t/T)');
x5=subs(x,'T',5);
ezplot(x5,[0:10]);grid on;

clear all;
x=sym('cos(2*pi*t/T)*sin(2*pi*t/T)');

x1=subs(x,'T',4);
figure;
ezplot(x1,[0:32]);xlabel('t');ylabel('T=4');grid on;
x2=subs(x,'T',8);
figure;
ezplot(x2,[0:32]);xlabel('t');ylabel('T=8');grid on;
x3=subs(x,'T',16);
figure;
ezplot(x3,[0:32]);xlabel('t');ylabel('T=16');grid on;