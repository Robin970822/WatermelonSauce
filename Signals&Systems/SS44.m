%%
clear;
a1=[1 3];
b1=3;
a2=[1 1/3];
b2=1/3;

w=linspace(0,10);
H1=freqs(b1,a1,w);
H2=freqs(b2,a2,w);

figure;
plot(w,abs(H1));xlabel('w');ylabel('|H1(jw)|');
figure;
plot(w,abs(H2));xlabel('w');ylabel('|H2(jw)|');
%%
t=linspace(0,5);
h1=impulse(b1,a1,t);
h2=impulse(b2,a2,t);

figure;
plot(w,h1);xlabel('t');ylabel('h1(t)');
figure;
plot(w,h2);xlabel('t');ylabel('h2(t)');