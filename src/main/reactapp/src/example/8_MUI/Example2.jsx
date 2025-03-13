// JOY UI :
// 1. 설치 : npm install @mui/joy @emotion/react @emotion/styled

// table : html   vs Table : mui컴포넌트
import Table from '@mui/joy/Table';

import Button from '@mui/joy/Button';
import { useState } from 'react';

import Modal from '@mui/joy/Modal';
import ModalClose from '@mui/joy/ModalClose';
import Typography from '@mui/joy/Typography';
import Sheet from '@mui/joy/Sheet';

import { BarChart } from '@mui/x-charts/BarChart';
import { LineChart } from '@mui/x-charts/LineChart';

export default function Example2(){

    const [open, setOpen] = useState(false);

    return (<>
        <h3> 테이블 </h3>
        <Table>
            <thead>
                <tr>
                    <th> 제목 </th> <th> 작성자 </th>
                </tr>
            </thead>
            <tbody>
                <tr> <td> 안녕하세요1 </td> <td> 유재석 </td> </tr>
                <tr> <td> 안녕하세요2 </td> <td> 강호동 </td> </tr>
            </tbody>
        </Table>

        <h3> 모달 </h3>

        <Button variant="outlined" color="neutral" onClick={ () => setOpen(true) }>
            모달창열기 true: 모달이 열린 상태 , false : 모달이 닫힌 상태 
        </Button>

        <Modal aria-labelledby="modal-title"  aria-describedby="modal-desc" open={open} onClose={() => setOpen(false)}
            sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}
        >
        <Sheet  variant="outlined" sx={{ maxWidth: 500, borderRadius: 'md', p: 3, boxShadow: 'lg' }} >
          <ModalClose variant="plain" sx={{ m: 1 }} />
            <Typography component="h2"  id="modal-title" level="h4"  textColor="inherit"  sx={{ fontWeight: 'lg', mb: 1 }}   >
                안녕하세요. 회원가입 축하합니다.
            </Typography>
            <Typography id="modal-desc" textColor="text.tertiary">
                로그인이후 다양한 기능들을 제공합니다.하하하하하하하하하
            </Typography>
            </Sheet>
        </Modal>

        <h3> 차트 </h3>
            {/* xAxis속성 data : [ 가로축 ] , series : 축의 값 */}
        <BarChart
            xAxis={ [ { scaleType: 'band', data: ['인사팀', '영업팀', '개발팀'] }]}
            series={ [ { data: [ 100, 100, 500] } , { data: [200, 80, 100] } , { data: [344, 70, 450] }  , { data: [400, 60, 50] } ] }
            width={500}
            height={300}
        />

        <LineChart
            xAxis={ [{ scaleType : 'band'   , data: [ "2023" , "2024" , "2025" , "2026" ] }]}
            series={[
                {
                    data: [1000000 , 12577274, 1245455 , 14743154 ] ,
                },
            ]}
            width={500}
            height={300}
        />

    </>)
}