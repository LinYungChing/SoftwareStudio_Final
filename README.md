# Software Studio Assignment 6
103062333 �L���M
103062334 ������
## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
	����assignment��import �F Ani.jar   controlIP5.jar    core.jar �T�� library


## Explanation of the Design
	�b�o����assignment���ڥD�n�u����@2��class, 
	�@�ӬOCharacter �̭��O��J.json�̭����C�@�Ӫ��󪺰򥻸��
	�t�@�ӬOMainApplet �̭���network��@,�ʵe��@,����H�ηƹ��ƥ��@
	1.�����p��N���󲾰ʨ�k��åB���Wnetwork:
		�ڭ̥H�@��integer�}�C inside[]�O�U�C�Ӫ��󪺪��A
		�Y��i�Ӫ���Q���ʨ�k��  �h�ڭ̱N inside[i] = 1 
		�]�����i�Ӫ���Q���ʨ�k��� �hinside[i] = 1
		 �ڭ̷|�].json���Ҧ�����Links���}�C
		�YŪ����links����source �� i ��   , �ڭ̫K�N��links����target�]�O�U��
		���ɭY inside[target] = 1 �N���target�]�b�k��j���W ���ɦb��Ulinks����value�ȷ�@���links���ʲ�
		�A�N��Ӫ����m�y�аO�U�� �õe�u�Y�i
	2.�����p���Ԫ���:
		�ڭ̪����k�O ��ƹ����U�h�� �|�O�U���ɪ��ƹ��y�� �åB�N�Ҧ�����Hfor�j��]�L�@��
		�Y�ƹ��y�лP�����߮y�Фp��Ӫ���b�|�� �K�i�H���D�ƹ����U�h�O���b����W
		���ɱN�Ӫ���enable=1  �Y�N��Ӫ��󦳷ƹ�����
		����  �s�W�@�� public void mouseDragged()
		��function�̭��P�_ ��Y����enable = 1 �� , �Ӫ���xy�y�з|��ƹ��y�Ф@��
		�Y�i������Ԫ���
	3.������J�k����H�Υk������ܪ����k
		�������ƹ���} �ڭ̷s�]�@��function �� public void mouseReleased()
		��function�P�_ ���U�ƹ���  ���ƹ�xy�y��  �P�k��j��骺��߮y�Фp��b�|��
		�Y�N�� �Ӫ���w�g�Q���ʨ�k�䪺�j���
		���ɳ]�@�ܼƬ�numOfcircle ��ܥk���馳�X�Ӫ���
		�A�N360/numOfcircle ��ܨC�Ӫ���n�۹j�X�Ө���
		���ۧQ��sin�H��cos���W�j���b�| �K�i�H�ǽT���N�k�䪺����H�������ת��覡��ܦb�j��骺�P���W(�Y���h���)
	4.�����p��@���N�Ҧ������J�k��餤:
		�̷ӤW�z�ĤT�I�H�βĤ@�I����
		���ɥu�n�N�Ҧ�����inside[i]=1
		�åB�A��numOfcircle = �����`��
		�Y�i���k�䪺�j���]�H���h��Ϊ��覡��ܩҦ�����
	5.�����p��N�����^��Ӧ�m:
		�]���W�z�ƹ���Ԫ���@  �ڭ̷|�N�{�b���b��Ԫ�����O�ĴX�Ӫ���O�U��(���]�O��i��)
		�S�ڭ̥�����ܪ��󪺤覡�� , �@�C��10�� ,��@�C�W�L10�Ӯɴ��s���@�C
		�B����C�Ӫ���۶Z60, �̥��W������y�Ь�30,30,
		�]���ڭ̥i�H�Ni/10���D�Ӫ���b�ĴX�C
		�Bi%10���D����b�ĴX��  
		�A�ε��t�żƤ����K�i�H�N�����^�쥻����m	
	6. �����p��@���N�k��Ҧ����󭫷s���ʨ쥪��:
		�̷Ӳ�5�I����  ���ɥu�n�Q�Τ@��for�j��]�Ҧ�������
		�åB�C�Ӫ��󳣰��W�z��5�I���Ʊ�
		�K�i�H�N�Ҧ����󲾰ʨ쥪��
	7.�������U�Ʀr���s�|�����P��episodes
		���������U���s �ڭ̦�public void keyPressed(KeyEvent e)
		����U���P���Ʀr1~7��
		Ū���ɮת�String file�|�̷Ӥ��Pepisode����
		���ۦbloadData���sŪ���ɮקY�i�ܴ�episodes	
	8.�����ʵe:
		�b�C�����ʦ^�h���L�{�����|���ʵe
		�ڭ̧Q��
		Ani.to(characters.get(i),(float)1.5,"x",posx);
		Ani.to(characters.get(i),(float)1.5,"y",posy);
		�i�H�N������H�ʵe���Φ��C�C���ʨ�posx,posy �Y�ڭ̷Q�n����m
	9.��ƹ������ʨ쪫��W��� �|��ܪ��󪺦W��
		�������ƹ����� �ڭ̦�public void mouseMoved()
		�O�U�C�@���ƹ����ʪ��ƹ�xy�y�Э�
		�æb�Τ@for�j��]���Ҧ������� �Y�Ӫ���P�ƹ��y�жZ���p�󪫥�b�|�� �h��ܥX�Ӫ���W��
		
### Operation

����assignment����@�����e
	1. ���U���s add all�ɥi�H�N���b��Ҧ�����������[�J�k��j��餤
		�åB�A�j��餤��ܪ���O�H���h��Ϊ��覡���
	2. ���U���sclear all �i�H�N�k�b��j��y�W���Ҧ�����������쥪��
		�åB�O���ʨ�ۤv�쥻����m
		�åB�C�Ӫ��󲾰ʦ^�h���ɭԳ��|���ʵe  , �O�w�C���ʦ^�h��
	3. �ϥΪ̥i�H�ηƹ���Ԫ��覡  �N�b���䪺����Ԩ�k�� 
		�����J��k��j�y���d��H������ �A��}  ����|�۰ʦb�y���P���W����ݩ�ۤv����m
		�b�k��j�y�W��ܪ�����  ���X�Ӫ���N�H���X��ΨӱƦC����
	4. �ϥΪ̥i�H�ηƹ���Ԫ��覡   �N�쥻�b�k�䪺����  �������
		�u�n�N��������}��P��
		����K�i�H�H�ʵe���覡�^��ۤv�쥻����m
	5. ���ޥ���ɭ�  �u�n�ƹ������ʨ�Y�@����W��  �Ӫ������N�|��ܥX�Ӫ��󪺦W�l
		�ƹ����}�����  ����W�٫K�|����
	6. ���U�Ʀr1~7   �K�i�H�ഫ  1~7�����P�� star wars episode
	7. �b�k�䪺network��ܤ�  ����V�j�P���������u�N�|�V��  �u���ʲӬO�Hjson��value�M�w

### Visualization
+ The width of each link is visualized based on the value of the link.
