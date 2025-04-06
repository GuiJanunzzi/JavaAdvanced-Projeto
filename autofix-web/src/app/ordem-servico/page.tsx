import { getOrdemServico } from '@/actions/ordem-servico-actions'
import Cabecalho from '@/components/Cabecalho'
import OrdemServicoItem from '@/components/ordem-servico-item'
import React from 'react'

export default async function page() {
  
  const dados : OrdemServico[] = await getOrdemServico()
  
  return (
    <>
        <Cabecalho ativo="ordem-servico"/>
        <main className='flex justify-center'>
            <div className='bg-gray-400 p-6 m-6 rounded min-w-1/3'>
                <h2>Ordem de Serviço</h2>

                {dados.map(ordemServico => <OrdemServicoItem key={ordemServico.id} ordemServico={ordemServico}/>)}
            </div>
        </main>
    </>
  )
}
