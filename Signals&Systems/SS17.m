clear;

f=sym('t*(Heaviside(t)-Heaviside(t-2))');
ezplot(f,[-5:0.5:5]);xlabel('t');ylabel('f(t)');grid on;axis equal;

g1=subs(f,'t','-t');
g2=subs(f,'t','t+1');
g3=subs(f,'t','t-3');
g4=subs(f,'t','-t+1');
g5=subs(f,'t','-2*t+1');

figure;
ezplot(g1,[-5:0.5:5]);xlabel('t');ylabel('g1(t)');grid on;axis equal;
figure;
ezplot(g2,[-5:0.5:5]);xlabel('t');ylabel('g2(t)');grid on;axis equal;
figure;
ezplot(g3,[-5:0.5:5]);xlabel('t');ylabel('g3(t)');grid on;axis equal;
figure;
ezplot(g4,[-5:0.5:5]);xlabel('t');ylabel('g4(t)');grid on;axis equal;
figure;
ezplot(g5,[-5:0.5:5]);xlabel('t');ylabel('g5(t)');grid on;axis equal;