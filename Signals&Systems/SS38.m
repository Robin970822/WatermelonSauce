%%
clear
a1=[1 -0.8];
b1=1;
a2=[1 0.8];
b2=1;
%%
N=1024;
[H1 omega1]=freqz(b1,a1,N,'whole');
[H2 omega2]=freqz(b2,a2,N,'whole');
plot(omega1,abs(H1));xlabel('omega1');ylabel('H1');
figure;
plot(omega2,abs(H2));xlabel('omega2');ylabel('H2');
%%
a=zeros(1,20);
a(1)=3/4;a(-1+20)=3/4;
a(9)=-1/2;a(-9+20)=-1/2;
stem([0:20],[0 a]);xlabel('w=(2*pi/20)k');