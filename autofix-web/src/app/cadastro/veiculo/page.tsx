import Cabecalho from '@/components/Cabecalho'
import { TriangleAlert } from 'lucide-react'
import React from 'react'

export default function page() {
  return (
    <>
        <Cabecalho ativo="cadastrar"/>
        <main className='flex justify-center'>
            <div className='bg-gray-400 p-6 m-6 rounded min-w-1/3'>
                <h2>Cadastro veiculo</h2>
                <div className='flex flex-col items-center mt-10'>
                  <TriangleAlert className='text-primary size-30'/>
                  <span className='text-primary text-4xl'>EM ANDAMENTO</span>
                </div>
            </div>
        </main>
    </>
  )
}
